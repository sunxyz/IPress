<template>
    <Main
            :showFolderDrawer.sync="showFolderDrawer"
            :showPageDrawer.sync="showPageDrawer"
            :showFolderDrawer2.sync="showFolderDrawer2"
    >
        <div slot="page"  style="padding: 10px">
            <span style="margin-right: 10px">标题</span> <Input placeholder="标题" style="width: 200px"/>
                        <span style="margin-right: 10px;margin-left: 20px">目录</span><Cascader :data="menus" v-model="selectMenus" style="width: 200px;display: inline-block"></Cascader>
            <br> <br><br>
            <!--            <vue-simple-markdown :source="value"></vue-simple-markdown>-->
<!--                        <mavon-editor v-model="value"/>-->
            <markdown-editor v-model="value" ref="markdownEditor" ></markdown-editor>
            <div class="demo-drawer-footer">
                <Button style="margin-right: 8px"　@click="showPageDrawer=false">取消</Button>
                <Button type="primary" @click="showPageDrawer=false">保存</Button>
            </div>
        </div>
        <div slot="folder-manager" style="padding: 10px">
            <Button shape="circle" @click="showFolderDrawer2=true">添加目录</Button>
            <br><br>
            <Table stripe :columns="columns" :data="data"></Table>
        </div>
        <div style="height: 1000px; width: 900px; margin: auto">
            hhhhhhhhhhhhhhhhhhh
        </div>
    </Main>
</template>

<script>
    import Main from '../components/layout'

    export default {
        name: "Test",
        components: {
            Main
        },
        data() {
            return {
                value: '',
                showFolderDrawer: false,
                showFolderDrawer2: false,
                showPageDrawer: false,
                selectMenus:[],
                menus:[{
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
                }],
                columns: [
                    {
                        title: '目录',
                        key: 'name'
                    },
                    {
                        title: '添加时间',
                        key: 'age'
                    },
                    {
                        title: '序号',
                        key: 'address'
                    },
                    {
                        title: '操作',
                        fixed: 'right',
                        width: 120,
                        render:(h,params)=>{
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'text',
                                        size: 'small'
                                    },
                                    on:{
                                        click:()=>{
                                            this.folderModel2=true
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
                data: [
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        date: '2016-10-03'
                    },
                    {
                        name: 'Jim Green',
                        age: 24,
                        address: 'London No. 1 Lake Park',
                        date: '2016-10-01'
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 'Sydney No. 1 Lake Park',
                        date: '2016-10-02'
                    },
                    {
                        name: 'Jon Snow',
                        age: 26,
                        address: 'Ottawa No. 2 Lake Park',
                        date: '2016-10-04'
                    }
                ],
            }
        }
    }
</script>

<style scoped>
    .demo-drawer-footer {
        width: 100%;
        padding: 30px 16px;
        text-align: right;
        background: #fff;
    }
</style>