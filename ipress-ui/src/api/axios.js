import axios from 'axios'

axios.defaults.baseURL = process.env.NODE_ENV === 'production' ? 'http://ipress-api.jinyijjia1688.com' : 'http://localhost:8086'
export default axios
