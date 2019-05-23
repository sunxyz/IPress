import {listFolderFlat, saveFolder, updateFolder ,deleteFolder} from '../../api/pocketApi'

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
                                },
                                on:{
                                    click:()=>{
                                        this.$Modal.confirm({
                                            title: '确认删除目录吗？',
                                            content: '确认删除目录吗？此操作会把该目录下的所有页面一并删除，请谨慎操作。',
                                            onOk: () => {
                                                this.deleteFolder(params.row.id);
                                            }
                                        });
                                    }
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
            listFolderFlat({pocketId: this.id}).then(d=>{
                this.folderData = d.data
            })
        },
        editFolder(id, item){
            this.folderId = id
            this.folderItem=Object.assign({
                name:'',
                parentId:undefined,
                sort:0,
                pocketId: this.id
            },item)
            this.showFolderDrawer2=true
        },
        deleteFolder(id){
            deleteFolder(id).then(()=>{
                this.loadFolderData()
                this.loadMenuTree()
                this.loadEntry()
            })
        },
        submitFolder(){
            if(this.folderId){
                updateFolder(this.folderId,this.folderItem).then(()=>{
                    this.loadFolderData()
                    this.loadMenuTree()
                    this.showFolderDrawer2=false
                })
            }else{
                saveFolder(this.folderItem).then(()=>{
                    this.loadFolderData()
                    this.loadMenuTree()
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