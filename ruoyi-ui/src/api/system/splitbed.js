import request from '@/utils/request'

// 查询分床记录列表
export function listSplitbed(query) {
  return request({
    url: '/system/splitbed/list',
    method: 'get',
    params: query
  })
}

// 查询分床记录详细
export function getSplitbed(id) {
  return request({
    url: '/system/splitbed/' + id,
    method: 'get'
  })
}

// 新增分床记录
export function addSplitbed(data) {
  return request({
    url: '/system/splitbed',
    method: 'post',
    data: data
  })
}

// 修改分床记录
export function updateSplitbed(data) {
  return request({
    url: '/system/splitbed',
    method: 'put',
    data: data
  })
}

// 删除分床记录
export function delSplitbed(id) {
  return request({
    url: '/system/splitbed/' + id,
    method: 'delete'
  })
}

// 导出分床记录
export function exportSplitbed(query) {
  return request({
    url: '/system/splitbed/export',
    method: 'get',
    params: query
  })
}