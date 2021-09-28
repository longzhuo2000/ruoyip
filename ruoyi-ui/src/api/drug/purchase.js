import request from '@/utils/request'

// 查询药品采购信息列表
export function listPurchase(query) {
  return request({
    url: '/drug/purchase/list',
    method: 'get',
    params: query
  })
}

// 查询药品采购信息详细
export function getPurchase(id) {
  return request({
    url: '/drug/purchase/' + id,
    method: 'get'
  })
}

// 新增药品采购信息
export function addPurchase(data) {
  return request({
    url: '/drug/purchase',
    method: 'post',
    data: data
  })
}

// 修改药品采购信息
export function updatePurchase(data) {
  return request({
    url: '/drug/purchase',
    method: 'put',
    data: data
  })
}

// 删除药品采购信息
export function delPurchase(id) {
  return request({
    url: '/drug/purchase/' + id,
    method: 'delete'
  })
}

// 导出药品采购信息
export function exportPurchase(query) {
  return request({
    url: '/drug/purchase/export',
    method: 'get',
    params: query
  })
}