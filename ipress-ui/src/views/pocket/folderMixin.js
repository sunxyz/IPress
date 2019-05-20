import {listFolderFlat, saveFolder, updateFolder ,deleteEntry} from '../../api/pocketApi'

export default {
    data () {
        return {
            showFolderDrawer: false,
            showFolderDrawer2: false,
            folderColumns:  [
                {
                    title: '目录名',
                    key: 'levelName'
                },
                {
                    title: '添加时间',
                    key: 'createdTime'
                },
                {
                    title: '序号',
                    key: 'sort'
                },
                {
                    title: '操作',
                    key: 'action',
                    fixed: 'right',
                    width: 120,
                    render: (h, params) => {
                        return h('div', [
                            h('Button', {
                                props: {
                                    type: 'text',
                                    size: 'small'
                                },
                                on:{
                                    click:()=>{
                                        this.editFolder(params.row.id, params.row)
                                    }
                                }
                            }, '编辑'),
                            h('Button', {
                                props: {
                                    type: 'text',
                                    size: 'small'
                                }
                            }, '删除')
                        ]);
                    }
                }
            ],
            folderData: [],
            folderId: undefined,
            folderItem:{
                name:'',
                parentId:undefined,
                sort:0
            }
        }
    },
    methods: {
        loadFolderData(){
            listFolderFlat().then(d=>{
                this.folderData = d.data
            })
        },
        editFolder(id, item){
            this.folderId = id
            this.folderItem=Object.assign({
                name:'',
                parentId:undefined,
                sort:0
            },item)
            this.showFolderDrawer2=true
        },
        deleteFolder(id){
            deleteEntry(id).then(()=>{
                this.loadFolderData()
            })
        },
        submitFolder(){
            if(this.folderId){
                updateFolder(this.folderId,this.folderItem).then(()=>{
                    this.loadFolderData()
                    this.showFolderDrawer2=false
                })
            }else{
                saveFolder(this.folderItem).then(()=>{
                    this.loadFolderData()
                    this.showFolderDrawer2=false
                })
            }
        }
    },
    watch:{
        showFolderDrawer(b){
            if(b){
                this.loadFolderData()
            }
        }
    }
}