import axios from 'axios'

const API = '/api/menu'

const ENTRY_API = '/api/entry'

export function listMenuTree(params = {}) {
    return axios.get(API + '/tree', {params});
}

export function listParentId(id, params = {}) {
    return axios.get(API + "/" + id + '/parents', {params});
}

export function listFolderFlat(params = {}) {
    return axios.get(API + '/folder', {params});
}

export function saveFolder(data) {
    return axios.post(API, data)
}

export function updateFolder(id, data) {
    return axios.put(`${API}/${id}`, data)
}

export function deleteFolder(id) {
    return axios.delete(`${API}/${id}`)
}

export function getEntry(id) {
    return axios.get(`${ENTRY_API}/${id}`)
}

export function saveEntry(data) {
    return axios.post(ENTRY_API, data)
}

export function updateEntry(id, data) {
    return axios.put(`${ENTRY_API}/${id}`, data)
}

export function deleteEntry(id) {
    return axios.delete(`${ENTRY_API}/${id}`)
}