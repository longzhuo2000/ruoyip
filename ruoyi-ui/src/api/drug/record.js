import request from '@/utils/request'

// 查询盘点记录列表
export function listRecord(query) {
  return request({
    url: '/drug/record/list',
    method: 'get',
    params: query
  })
}

// 查询盘点记录详细
export function getRecord(id) {
  return request({
    url: '/drug/record/' + id,
    method: 'get'
  })
}

// 新增盘点记录
export function addRecord(data) {
  return request({
    url: '/drug/record',
    method: 'post',
    data: data
  })
}

// 修改盘点记录
export function updateRecord(data) {
  return request({
    url: '/drug/record',
    method: 'put',
    data: data
  })
}

// 删除盘点记录
export function delRecord(id) {
  return request({
    url: '/drug/record/' + id,
    method: 'delete'
  })
}

// 导出盘点记录
export function exportRecord(query) {
  return request({
    url: '/drug/record/export',
    method: 'get',
    params: query
  })
}