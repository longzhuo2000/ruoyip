import request from '@/utils/request'

// 查询药品列表
export function listInfo(query) {
  return request({
    url: '/drug/info/list',
    method: 'get',
    params: query
  })
}

// 查询药品详细
export function getInfo(id) {
  return request({
    url: '/drug/info/' + id,
    method: 'get'
  })
}

// 新增药品
export function addInfo(data) {
  return request({
    url: '/drug/info',
    method: 'post',
    data: data
  })
}

// 修改药品
export function updateInfo(data) {
  return request({
    url: '/drug/info',
    method: 'put',
    data: data
  })
}

// 删除药品
export function delInfo(id) {
  return request({
    url: '/drug/info/' + id,
    method: 'delete'
  })
}

// 导出药品
export function exportInfo(query) {
  return request({
    url: '/drug/info/export',
    method: 'get',
    params: query
  })
}