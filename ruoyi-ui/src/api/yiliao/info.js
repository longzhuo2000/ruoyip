import request from '@/utils/request'

// 查询门诊卡信息列表
export function listInfo(query) {
  return request({
    url: '/yiliao/info/list',
    method: 'get',
    params: query
  })
}

// 查询门诊卡信息详细
export function getInfo(id) {
  return request({
    url: '/yiliao/info/' + id,
    method: 'get'
  })
}

// 新增门诊卡信息
export function addInfo(data) {
  return request({
    url: '/yiliao/info',
    method: 'post',
    data: data
  })
}

// 修改门诊卡信息
export function updateInfo(data) {
  return request({
    url: '/yiliao/info',
    method: 'put',
    data: data
  })
}

// 删除门诊卡信息
export function delInfo(id) {
  return request({
    url: '/yiliao/info/' + id,
    method: 'delete'
  })
}

// 导出门诊卡信息
export function exportInfo(query) {
  return request({
    url: '/yiliao/info/export',
    method: 'get',
    params: query
  })
}