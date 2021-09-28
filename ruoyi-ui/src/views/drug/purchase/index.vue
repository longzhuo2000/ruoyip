<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="药品名称ID" prop="drugsid">
        <el-select v-model="queryParams.drugsid" placeholder="请选择药品名称ID" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="药品来源" prop="source">
        <el-input
          v-model="queryParams.source"
          placeholder="请输入药品来源"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产地" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入产地"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="批号" prop="batchnumbe">
        <el-input
          v-model="queryParams.batchnumbe"
          placeholder="请输入批号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生产日期" prop="manufacturetime">
        <el-date-picker clearable size="small"
          v-model="queryParams.manufacturetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择生产日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="有效期" prop="termofvalidity">
        <el-date-picker clearable size="small"
          v-model="queryParams.termofvalidity"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择有效期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="填制人" prop="filledby">
        <el-input
          v-model="queryParams.filledby"
          placeholder="请输入填制人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="核查人" prop="verifier">
        <el-input
          v-model="queryParams.verifier"
          placeholder="请输入核查人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="核查日期" prop="verificationtime">
        <el-date-picker clearable size="small"
          v-model="queryParams.verificationtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择核查日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="审核人" prop="reviewer">
        <el-input
          v-model="queryParams.reviewer"
          placeholder="请输入审核人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="审核日期" prop="audittime">
        <el-date-picker clearable size="small"
          v-model="queryParams.audittime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择审核日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="数量" prop="no">
        <el-input
          v-model="queryParams.no"
          placeholder="请输入数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['drug:purchase:add']"
        >采购</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['drug:purchase:edit']"
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
          v-hasPermi="['drug:purchase:remove']"
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
          v-hasPermi="['drug:purchase:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="purchaseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="药品名称ID" align="center" prop="drugsid" />
      <el-table-column label="药品来源" align="center" prop="source" />
      <el-table-column label="产地" align="center" prop="address" />
      <el-table-column label="批号" align="center" prop="batchnumbe" />
      <el-table-column label="生产日期" align="center" prop="manufacturetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.manufacturetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="有效期" align="center" prop="termofvalidity" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.termofvalidity, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="摘要" align="center" prop="abstracts" />
      <el-table-column label="填制人" align="center" prop="filledby" />
      <el-table-column label="核查人" align="center" prop="verifier" />
      <el-table-column label="核查日期" align="center" prop="verificationtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.verificationtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="审核人" align="center" prop="reviewer" />
      <el-table-column label="审核日期" align="center" prop="audittime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.audittime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="数量" align="center" prop="no" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['drug:purchase:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['drug:purchase:remove']"
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

    <!-- 添加或修改药品采购信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="随机" prop="id">
          <el-input v-model="form.id" placeholder="请输入随机" />
        </el-form-item>
        <el-form-item label="药品名称ID" prop="drugsid">
          <el-select v-model="form.drugsid" placeholder="请选择药品名称ID">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="药品来源" prop="source">
          <el-input v-model="form.source" placeholder="请输入药品来源" />
        </el-form-item>
        <el-form-item label="产地" prop="address">
          <el-input v-model="form.address" placeholder="请输入产地" />
        </el-form-item>
        <el-form-item label="批号" prop="batchnumbe">
          <el-input v-model="form.batchnumbe" placeholder="请输入批号" />
        </el-form-item>
        <el-form-item label="生产日期" prop="manufacturetime">
          <el-date-picker clearable size="small"
            v-model="form.manufacturetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择生产日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="有效期" prop="termofvalidity">
          <el-date-picker clearable size="small"
            v-model="form.termofvalidity"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择有效期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="摘要" prop="abstracts">
          <el-input v-model="form.abstracts" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="填制人" prop="filledby">
          <el-input v-model="form.filledby" placeholder="请输入填制人" />
        </el-form-item>
        <el-form-item label="核查人" prop="verifier">
          <el-input v-model="form.verifier" placeholder="请输入核查人" />
        </el-form-item>
        <el-form-item label="核查日期" prop="verificationtime">
          <el-date-picker clearable size="small"
            v-model="form.verificationtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择核查日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核人" prop="reviewer">
          <el-input v-model="form.reviewer" placeholder="请输入审核人" />
        </el-form-item>
        <el-form-item label="审核日期" prop="audittime">
          <el-date-picker clearable size="small"
            v-model="form.audittime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择审核日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="数量" prop="no">
          <el-input v-model="form.no" placeholder="请输入数量" />
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
import { listPurchase, getPurchase, delPurchase, addPurchase, updatePurchase, exportPurchase } from "@/api/drug/purchase";

export default {
  name: "Purchase",
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
      // 药品采购信息表格数据
      purchaseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        drugsid: null,
        source: null,
        address: null,
        batchnumbe: null,
        manufacturetime: null,
        termofvalidity: null,
        abstracts: null,
        filledby: null,
        verifier: null,
        verificationtime: null,
        reviewer: null,
        audittime: null,
        no: null
      },
      // 表单参数
      form: {},
      formDto:{
        purchase:{},
        record:{}
      },
      // 表单校验
      rules: {
        source: [
          { required: true, message: "药品来源不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "产地不能为空", trigger: "blur" }
        ],
        batchnumbe: [
          { required: true, message: "批号不能为空", trigger: "blur" }
        ],
        manufacturetime: [
          { required: true, message: "生产日期不能为空", trigger: "blur" }
        ],
        termofvalidity: [
          { required: true, message: "有效期不能为空", trigger: "blur" }
        ],
        filledby: [
          { required: true, message: "填制人不能为空", trigger: "blur" }
        ],
        verifier: [
          { required: true, message: "核查人不能为空", trigger: "blur" }
        ],
        verificationtime: [
          { required: true, message: "核查日期不能为空", trigger: "blur" }
        ],
        reviewer: [
          { required: true, message: "审核人不能为空", trigger: "blur" }
        ],
        audittime: [
          { required: true, message: "审核日期不能为空", trigger: "blur" }
        ],
        no: [
          { required: true, message: "数量不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询药品采购信息列表 */
    getList() {
      this.loading = true;
      listPurchase(this.queryParams).then(response => {
        this.purchaseList = response.rows;
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
        source: null,
        address: null,
        batchnumbe: null,
        manufacturetime: null,
        termofvalidity: null,
        abstracts: null,
        filledby: null,
        verifier: null,
        verificationtime: null,
        reviewer: null,
        audittime: null,
        no: null
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
      this.title = "药品采购";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPurchase(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改药品采购信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePurchase(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPurchase(this.formDto).then(response => {
              this.formDto.purchase=this.form;
              this.formDto.record.drugsid=this.form.drugsid;
              this.formDto.record.papernumber=this.form.no;
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
      this.$modal.confirm('是否确认删除药品采购信息编号为"' + ids + '"的数据项？').then(function() {
        return delPurchase(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有药品采购信息数据项？').then(() => {
        this.exportLoading = true;
        return exportPurchase(queryParams);
      }).then(response => {
        this.download(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
