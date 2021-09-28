<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="1草稿2发送3撤回4退回5完成认领" prop="statue">
        <el-input
          v-model="queryParams.statue"
          placeholder="请输入1草稿2发送3撤回4退回5完成认领"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="药品表ID" prop="partid">
        <el-input
          v-model="queryParams.partid"
          placeholder="请输入药品表ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单位支/盒/克" prop="parttype">
        <el-select v-model="queryParams.parttype" placeholder="请选择单位支/盒/克" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="用量" prop="partno">
        <el-input
          v-model="queryParams.partno"
          placeholder="请输入用量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="录入时间" prop="moretime">
        <el-date-picker clearable size="small"
          v-model="queryParams.moretime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择录入时间">
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
          v-hasPermi="['hospital:prescriptiontotal:add']"
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
          v-hasPermi="['hospital:prescriptiontotal:edit']"
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
          v-hasPermi="['hospital:prescriptiontotal:remove']"
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
          v-hasPermi="['hospital:prescriptiontotal:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="prescriptiontotalList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="随机" align="center" prop="id" />
      <el-table-column label="1草稿2发送3撤回4退回5完成认领" align="center" prop="statue">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.cpoe_prescriptiontotal_state" :value="scope.row.statue"/>
        </template>
      </el-table-column>
      <el-table-column label="药品表ID" align="center" prop="partid" />
      <el-table-column label="单位支/盒/克" align="center" prop="parttype" />
      <el-table-column label="用量" align="center" prop="partno" />
      <el-table-column label="录入时间" align="center" prop="moretime" width="180">
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
            v-hasPermi="['hospital:prescriptiontotal:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hospital:prescriptiontotal:remove']"
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

    <!-- 添加或修改住院治疗处方总对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="1草稿2发送3撤回4退回5完成认领" prop="statue">
          <el-input v-model="form.statue" placeholder="请输入1草稿2发送3撤回4退回5完成认领" />
        </el-form-item>
        <el-form-item label="药品表ID" prop="partid">
          <el-input v-model="form.partid" placeholder="请输入药品表ID" />
        </el-form-item>
        <el-form-item label="单位支/盒/克" prop="parttype">
          <el-select v-model="form.parttype" placeholder="请选择单位支/盒/克">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="用量" prop="partno">
          <el-input v-model="form.partno" placeholder="请输入用量" />
        </el-form-item>
        <el-form-item label="录入时间" prop="moretime">
          <el-date-picker clearable size="small"
            v-model="form.moretime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择录入时间">
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
import { listPrescriptiontotal, getPrescriptiontotal, delPrescriptiontotal, addPrescriptiontotal, updatePrescriptiontotal, exportPrescriptiontotal } from "@/api/hospital/prescriptiontotal";

export default {
  name: "Prescriptiontotal",
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
      // 住院治疗处方总表格数据
      prescriptiontotalList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        statue: null,
        partid: null,
        parttype: null,
        partno: null,
        moretime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询住院治疗处方总列表 */
    getList() {
      this.loading = true;
      listPrescriptiontotal(this.queryParams).then(response => {
        this.prescriptiontotalList = response.rows;
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
        statue: null,
        partid: null,
        parttype: null,
        partno: null,
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
      this.title = "添加住院治疗处方总";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPrescriptiontotal(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改住院治疗处方总";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePrescriptiontotal(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPrescriptiontotal(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除住院治疗处方总编号为"' + ids + '"的数据项？').then(function() {
        return delPrescriptiontotal(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有住院治疗处方总数据项？').then(() => {
        this.exportLoading = true;
        return exportPrescriptiontotal(queryParams);
      }).then(response => {
        this.download(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
