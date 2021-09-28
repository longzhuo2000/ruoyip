<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="药品名称ID" prop="drugsid">
        <el-input
          v-model="queryParams.drugsid"
          placeholder="请输入药品名称ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="账面数量" prop="papernumber">
        <el-input
          v-model="queryParams.papernumber"
          placeholder="请输入账面数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实存数量" prop="existnumber">
        <el-input
          v-model="queryParams.existnumber"
          placeholder="请输入实存数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="购进单价" prop="buyunitprice">
        <el-input
          v-model="queryParams.buyunitprice"
          placeholder="请输入购进单价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="零售单价" prop="sellunitprice">
        <el-input
          v-model="queryParams.sellunitprice"
          placeholder="请输入零售单价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="盘盈数量" prop="inventorysurplusno">
        <el-input
          v-model="queryParams.inventorysurplusno"
          placeholder="请输入盘盈数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="盘点时间" prop="moretime">
        <el-date-picker clearable size="small"
          v-model="queryParams.moretime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择盘点时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['drug:record:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['drug:record:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['drug:record:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['drug:record:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="recordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="随机" align="center" prop="id" />
      <el-table-column label="药品名称ID" align="center" prop="drugsid" />
      <el-table-column label="账面数量" align="center" prop="papernumber" />
      <el-table-column label="实存数量" align="center" prop="existnumber" />
      <el-table-column label="购进单价" align="center" prop="buyunitprice" />
      <el-table-column label="零售单价" align="center" prop="sellunitprice" />
      <el-table-column label="盘盈数量" align="center" prop="inventorysurplusno" />
      <el-table-column label="盘点时间" align="center" prop="moretime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.moretime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['drug:record:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['drug:record:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改盘点记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="药品名称ID" prop="drugsid">
          <el-input v-model="form.drugsid" placeholder="请输入药品名称ID" />
        </el-form-item>
        <el-form-item label="账面数量" prop="papernumber">
          <el-input v-model="form.papernumber" placeholder="请输入账面数量" />
        </el-form-item>
        <el-form-item label="实存数量" prop="existnumber">
          <el-input v-model="form.existnumber" placeholder="请输入实存数量" />
        </el-form-item>
        <el-form-item label="购进单价" prop="buyunitprice">
          <el-input v-model="form.buyunitprice" placeholder="请输入购进单价" />
        </el-form-item>
        <el-form-item label="零售单价" prop="sellunitprice">
          <el-input v-model="form.sellunitprice" placeholder="请输入零售单价" />
        </el-form-item>
        <el-form-item label="盘盈数量" prop="inventorysurplusno">
          <el-input v-model="form.inventorysurplusno" placeholder="请输入盘盈数量" />
        </el-form-item>
        <el-form-item label="盘点时间" prop="moretime">
          <el-date-picker clearable size="small"
            v-model="form.moretime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择盘点时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRecord, getRecord, delRecord, addRecord, updateRecord, exportRecord } from "@/api/drug/record";

export default {
  name: "Record",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 盘点记录表格数据
      recordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        drugsid: null,
        papernumber: null,
        existnumber: null,
        buyunitprice: null,
        sellunitprice: null,
        inventorysurplusno: null,
        moretime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        papernumber: [
          { required: true, message: "账面数量不能为空", trigger: "blur" }
        ],
        existnumber: [
          { required: true, message: "实存数量不能为空", trigger: "blur" }
        ],
        buyunitprice: [
          { required: true, message: "购进单价不能为空", trigger: "blur" }
        ],
        sellunitprice: [
          { required: true, message: "零售单价不能为空", trigger: "blur" }
        ],
        inventorysurplusno: [
          { required: true, message: "盘盈数量不能为空", trigger: "blur" }
        ],
        moretime: [
          { required: true, message: "盘点时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询盘点记录列表 */
    getList() {
      this.loading = true;
      listRecord(this.queryParams).then(response => {
        this.recordList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        drugsid: null,
        papernumber: null,
        existnumber: null,
        buyunitprice: null,
        sellunitprice: null,
        inventorysurplusno: null,
        moretime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加盘点记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改盘点记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecord(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除盘点记录编号为"' + ids + '"的数据项？').then(function() {
        return delRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有盘点记录数据项？').then(() => {
        this.exportLoading = true;
        return exportRecord(queryParams);
      }).then(response => {
        this.download(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
