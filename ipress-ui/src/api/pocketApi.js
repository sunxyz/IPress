import axios from 'axios'

const API = '/api/menu'

export function listMenuTree(params = {}) {
    return axios.get(API + '/tree', {params});
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