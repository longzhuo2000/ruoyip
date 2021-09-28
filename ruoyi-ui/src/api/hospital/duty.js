import request from '@/utils/request'

// 查询病房值班记录列表
export function listDuty(query) {
  return request({
    url: '/hospital/duty/list',
    method: 'get',
    params: query
  })
}

// 查询病房值班记录详细
export function getDuty(id) {
  return request({
    url: '/hospital/duty/' + id,
    method: 'get'
  })
}

// 新增病房值班记录
export function addDuty(data) {
  return request({
    url: '/hospital/duty',
    method: 'post',
    data: data
  })
}

// 修改病房值班记录
export function updateDuty(data) {
  return request({
    url: '/hospital/duty',
    method: 'put',
    data: data
  })
}

// 删除病房值班记录
export function delDuty(id) {
  return request({
    url: '/hospital/duty/' + id,
    method: 'delete'
  })
}

// 导出病房值班记录
export function exportDuty(query) {
  return request({
    url: '/hospital/duty/export',
    method: 'get',
    params: query
  })
}