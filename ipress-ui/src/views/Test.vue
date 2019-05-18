<template>
    <Main
            :showFolderDrawer.sync="showFolderDrawer"
            :showPageDrawer.sync="showPageDrawer"
            :showFolderDrawer2.sync="showFolderDrawer2"
            :menuList="menuList"
    >
        <div slot="page" style="padding: 10px">
            <span style="margin-right: 10px">标题</span> <Input placeholder="标题" style="width: 200px"/>
            <span style="margin-right: 10px;margin-left: 20px">目录</span>
            <Cascader :data="folders" v-model="selectFolder" style="width: 200px;display: inline-block"></Cascader>
            <br> <br><br>
            <!--            <vue-simple-markdown :source="value"></vue-simple-markdown>-->
            <!--                        <mavon-editor v-model="value"/>-->
            <markdown-editor v-model="value" ref="markdownEditor"></markdown-editor>
            <div class="demo-drawer-footer">
                <Button style="margin-right: 8px" 　@click="showPageDrawer=false">取消</Button>
                <Button type="primary" @click="showPageDrawer=false">保存</Button>
            </div>
        </div>
        <div slot="folder-manager" style="padding: 10px">
            <Button shape="circle" @click="editFolder()">添加目录</Button>
            <br><br>
            <Table stripe :columns="folderColumns" :data="folderData"/>
        </div>
        <div slot="folder-form">
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
        </div>
        <div style="height: 1000px; width: 900px; margin: auto">
            hhhhhhhhhhhhhhhhhhh
            ---- {{id}}
        </div>
    </Main>
</template>

<script>
    import Main from '../components/layout'
    import {listMenuTree} from '../api/pocketApi'
    import folderMixin from './pocket/folderMixin'
    export default {
        name: "Test",
        mixins:[folderMixin],
        props: {
            id: {
                type: String
            }
        },
        components: {
            Main
        },
        data() {
            return {
                value: '',
                showPageDrawer: false,
                menuList: [],
                selectFolder: [],
                folders: [{
                    value: 'zhejiang',
                    label: '浙江',
                    children: [{
                        value: 'hangzhou',
                        label: '杭州',
                        children: [{
                            value: 'xihu',
                            label: '西湖'
                        }]
                    }]
                }, {
                    value: 'jiangsu',
                    label: '江苏',
                    disabled: true,
                    children: [{
                        value: 'nanjing',
                        label: '南京',
                        children: [{
                            value: 'zhonghuamen',
                            label: '中华门'
                        }]
                    }]
                }]
            }
        },
        mounted(){
            listMenuTree({id: this.id}).then(d => {
                this.menuList = d.data
            })
        },
        beforeRouteUpdate(to, from, next) {
            listMenuTree({id: this.id}).then(d => {
                this.menuList = d.data
            })
            next()
        }
    }
</script>

<style scoped>
    .demo-drawer-footer {
        width: 100%;
        padding: 30px 16px;
        text-align: left;
        background: #fff;
    }
</style>