import axios from 'axios'

const API = '/api/pocket'

export function list() {
    return axios.get(API)
}

export function save(data) {
    return axios.post(API, data)
}

export function update(id, data) {
    return axios.put(`${API}/${id}`,data)
}

