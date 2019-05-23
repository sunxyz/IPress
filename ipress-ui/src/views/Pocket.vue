<template>
    <div style="height: 100%">
        <Main :menus="menus" 　 @on-click-folder="clickFolder" @on-click-entry="clickEntry" :menuActiveId="menuActiveId"
              :menuOpenedIds="menuOpenedIds" 　@on-select="onSelect">
            <div style="max-width: 900px;margin:0 auto">
                <h1>{{entry.title}}</h1>
                <div style="border-bottom: 1px solid #eee ;width: 100%;height: 30px"></div>
                <div style="height: 30px"></div>
                <vue-simple-markdown :source="entry.mdContent"></vue-simple-markdown>
            </div>
        </Main>
        <Drawer
                placement="left"
                :closable="false"
                @on-close="showFolderDrawer=false"
                :value="showFolderDrawer"
                width="50%">
            <Button shape="circle" @click="editFolder()">添加目录</Button>
            <br><br>
            <Table stripe :columns="folderColumns" :data="folderData"/>
        </Drawer>
        <Drawer
                :closable="false"
                @on-close="showFolderDrawer2=false"
                :value="showFolderDrawer2"
                width="50%">
            <Form :model="folderItem" :label-width="80">
                <FormItem label="目录名">
                    <Input v-model="folderItem.name" placeholder="请输入目录名..." style="width:200px"/>
                </FormItem>
                <FormItem label="上级目录">
                    <Select v-model="folderItem.parentId" style="width:200px">
                        <Option v-for="item in folderData" :value="item.id" :key="item.id">{{ item.levelName }}</Option>
                    </Select>
                </FormItem>
                <FormItem label="序号">
                    <InputNumber v-model="folderItem.sort" placeholder="请输入序号..."/>
                </FormItem>
            </Form>
            <div class="demo-drawer-footer">
                <Button style="margin-right: 8px" 　@click="showFolderDrawer2=false">取消</Button>
                <Button type="primary" @click="submitFolder">保存</Button>
            </div>
        </Drawer>
        <Drawer
                placement="left"
                :closable="false"
                @on-close="showPageDrawer=false"
                :value="showPageDrawer"
                width="50%">
            <span style="margin-right: 10px">标题</span> <Input placeholder="标题" 　v-model="entryItem.title"
                                                              style="width: 200px"/>
            <span style="margin-right: 10px;margin-left: 20px">目录</span>
            <Select v-model="entryItem.parentMenuId" style="width:200px">
                <Option v-for="item in folderData" :value="item.id" :key="item.id">{{ item.levelName }}</Option>
            </Select>
            <br> <br><br>
            <!--            <vue-simple-markdown :source="value"></vue-simple-markdown>-->
            <!--            <mavon-editor v-model="entryItem.mdContent"/>-->
            <markdown-editor v-model="entryItem.mdContent" ref="markdownEditor"></markdown-editor>
            <div class="demo-drawer-footer">
                <Button style="margin-right: 8px" 　@click="showPageDrawer=false">取消</Button>
                <Button type="primary" @click="submitEntry">保存</Button>
            </div>
        </Drawer>

        <div class="author-ctl" v-show="entryId">
            <Tooltip content="编辑" placement="right">
                <Icon type="ios-create-outline" size="30" @click="edit(entryId)"/>
            </Tooltip>
            <br><br>
            <div>
                <Poptip placement="left"
                        trigger="hover"
                >
                    <Icon type="ios-trash-outline" size="30"/>

                    <div slot="content">
                        确认删除?
                        <br><br>

                        <Button type="error" size="small" @click="deleteEntry(entryId)">确认</Button>
                    </div>

                </Poptip>
            </div>
        </div>
    </div>

</template>

<script>
    import {listMenuTree, listParentId} from '../api/pocketApi'
    import folderMixin from './pocket/folderMixin'
    import entryMixin from './pocket/entryMixin'
    import Main from '../components/layout'
    import {getEntry, deleteEntry} from '../api/pocketApi'

    export default {
        name: "Pocket",
        mixins: [folderMixin, entryMixin],
        props: {
            id: {
                type: String
            }
        },
        data() {
            return {
                menus: [],
                entry: {
                    title: '',
                    mdContent: ''
                },
                menuActiveId: "20190520182929a64e26ca",
                menuOpenedIds: [],
            }
        },
        components: {
            Main
        },
        methods: {
            clickFolder() {
                this.showFolderDrawer = true
            },
            clickEntry() {
                this.addEntry()
            },
            onSelect(id) {
                this.$router.push(Object.assign({}, this.$route, {query: {p: id}}))
            },
            loadMenuTree() {
                listMenuTree({pocketId: this.id}).then(d => {
                    this.menus = d.data
                })
            },
            loadEntry() {
                if (this.$route.query.p) {
                    this.entryId = this.$route.query.p
                    getEntry(this.entryId).then(d => {
                        this.entry = d.data
                    })
                }
            },
            addEntry() {
                this.loadFolderData()
                this.editEntry()
            },
            edit(id) {
                this.loadFolderData()
                getEntry(id).then(d => {
                    this.editEntry(id, d.data)
                })
            },
            deleteEntry(id) {
                deleteEntry(id).then(() => {
                    this.$Message.success('删除成功')
                    this.initData()
                }).catch(() => {
                    this.$Message.error('删除失败')
                })
            },
            loadAllData() {
                this.loadMenuTree()
                this.loadEntry()
            }
        },
        mounted() {
            this.loadEntry()
            if (this.$route.query.p) {
                listMenuTree({pocketId: this.id}).then(d => {
                    this.menus = d.data
                    this.$nextTick(() => {
                        listParentId(this.$route.query.p).then(d => {
                            this.menuOpenedIds = d.data
                        })
                        this.menuActiveId = this.$route.query.p
                    })
                })

            } else {
                listMenuTree({pocketId: this.id}).then(d => {
                    this.menus = d.data
                })
            }


        },
        watch: {
            $route() {
                this.loadAllData()
            }
        }
    }
</script>
<style scoped lang="less">
    .author-ctl {
        background: #f6f6f6;
        width: 50px;
        height: 100px;
        position: fixed;
        right: 50px;
        top: 150px;
        padding: 10px;
        text-align: center;
        border-radius: 16px;
        border: 1px solid #f1f1f1;
    }
</style>