<!--
<template>
    <div class="container">
        <div class="left"></div>
        <div class="right"></div>
    </div>
</template>
<style scoped lang="less">
    .container{
        background: #999;
        height: 100%;
        width: 100%;
        display: flex;
        justify-content: left;
        .left{
            width: 75px;
            height: 100%;
            background: #42b983;
        }
        .right{

            flex: auto;
            height: 100%;
            background: #2d8cf0;
        }
    }
</style>-->
<style  lang="less">
    .main {
        .logo-con {
            height: 64px;
            padding: 10px;

            img {
                height: 44px;
                width: auto;
                display: block;
                margin: 0 auto;
            }
        }

        .main-layout-con {
            height: 100%;
            overflow: hidden;
        }

        .main-content-con {
            height: ~"calc(100% - 60px)";
            overflow: hidden;
        }


        .content-wrapper {
            /*padding: 18px;*/
            height: ~"calc(100% - 80px)";
            overflow: auto;
        }

        .left-sider {
            .ivu-layout-sider-children {
                overflow-y: scroll;
                margin-right: -18px;
            }
        }
    }



</style>
<style lang="less">
    .ivu-layout-sider-trigger {
        color: #515a6e;
        background: #fff;
        border-right: 1px solid #e6e6e6;
    }

    .ivu-menu {
        position: static;
    }
    .ivu-menu-light.ivu-menu-vertical .ivu-menu-item-active:not(.ivu-menu-submenu):after {
        right: 2px;
    }
</style>
<style scoped lang="less">

    .demo-drawer-footer {
        width: 100%;
        position: absolute;
        bottom: 0;
        left: 0;
        border-top: 1px solid #e8e8e8;
        padding: 10px 16px;
        text-align: right;
        background: #fff;
    }
    .ctrl>ul{
        list-style: none;
        text-align: center;
        &>li{
            margin: 20px ;
        }
    }
    .author-ctl{
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
<template>
    <Layout style="height: 100%" class="main">
        <Sider collapsible :width="300" :collapsed-width="78" v-model="isCollapsed" class="left-sider"
               :style="{background: '#fff',overflow:''}">
            <div class="side-menu-wrapper">
                <div v-show="!isCollapsed">
                    <div style="margin: 20px;box-sizing: border-box">
                        <Input placeholder="输入关键字后按回车进行搜索"/>
                        <div style="margin-top:15px;display: flex;justify-content: space-between">
                            <div>
                                <Tooltip content="主页" placement="left">
                                    <Button shape="circle" icon="ios-home-outline" style="margin: 5px 0px"
                                            @click="$router.push({name:'home'})"></Button>
                                </Tooltip>
                            </div>
                            <div>
                                <Tooltip content="新建/管理目录" placement="left">
                                    <Button shape="circle" type="primary" icon="ios-folder-outline"
                                            style="margin: 5px 8px" @click="openFolderDrawer"></Button>
                                </Tooltip>
                                <Tooltip content="新建页面" placement="right">
                                    <Button shape="circle" type="primary" icon="ios-add" style="margin: 5px  0 5px 8px"
                                            @click="openPageDrawer"></Button>
                                </Tooltip>
                            </div>

                        </div>

                    </div>

                    <Menu :active-name="activeMenuName" width="auto" :class="menuitemClasses">

                        <Submenu name="1">
                            <template slot="title">
                                <Icon type="ios-folder-outline"/>
                                Navigation One
                            </template>
                            <MenuGroup title="Item 1">
                                <MenuItem name="1-1">Option 1</MenuItem>
                                <MenuItem name="1-2">Option 2</MenuItem>
                            </MenuGroup>
                            <MenuGroup title="Item 2">
                                <MenuItem name="1-3">Option 3</MenuItem>
                                <MenuItem name="1-4">Option 4</MenuItem>
                            </MenuGroup>
                        </Submenu>
                        <Submenu name="2">
                            <template slot="title">
                                <Icon type="ios-folder-outline"/>
                                Navigation One
                            </template>
                            <MenuGroup title="Item 1">
                                <MenuItem name="1-1">
                                    <Icon type="ios-document-outline"/>
                                    Option 1
                                </MenuItem>
                                <MenuItem name="1-2">
                                    <Icon type="ios-document-outline"/>
                                    Option 2
                                </MenuItem>
                            </MenuGroup>
                            <MenuGroup title="Item 2">
                                <MenuItem name="1-3">
                                    <Icon type="ios-document-outline"/>
                                    Option 3
                                </MenuItem>
                                <MenuItem name="1-4">
                                    <Icon type="ios-document-outline"/>
                                    Option 4
                                </MenuItem>
                            </MenuGroup>
                        </Submenu>

                    </Menu>
                </div>
                <div v-show="isCollapsed" style="text-align: center;padding: 5px">
                    <h2 style="cursor: pointer; margin-top: 10px;" @click="$router.push({name:'home'})">IPress</h2>
                    <div class="ctrl">
                        <ul>
                            <li>
                                <Tooltip content="新建页面" placement="right">
                                    <Button shape="circle" type="primary" icon="ios-add" @click="openPageDrawer"></Button>
                                </Tooltip>

                            </li>
                            <li>
                                <Tooltip content="新建/管理目录" placement="right">
                                    <Button shape="circle" type="primary" icon="ios-folder-outline"
                                            @click="openFolderDrawer"></Button>
                                </Tooltip>
                            </li>
                        </ul>

                        <ul>
                            <li><Dropdown placement="right-start" ref="dropdown">
                                <Icon type="ios-folder-outline" size="26" style="cursor: pointer; margin-right: 30px"></Icon>

                                <DropdownMenu slot="list">
                                    <DropdownItem>驴打滚</DropdownItem>
                                    <DropdownItem>炸酱面</DropdownItem>
                                    <DropdownItem>豆汁儿</DropdownItem>
                                    <DropdownItem>冰糖葫芦</DropdownItem>
                                    <DropdownItem>北京烤鸭</DropdownItem>
                                </DropdownMenu>
                            </Dropdown></li>
                        </ul>
                    </div>
                </div>
            </div>

        </Sider>
        <Layout>
            <Content class="main-content-con">
                <Layout class="main-layout-con">
                    <Content class="content-wrapper">
                        <Card style="height: 1600px;width: 100%">dsdsfdsfdsf</Card>
                    </Content>
                    <Drawer placement="left"  :closable="false" v-model="folderModel" width="50%">
                        <Button shape="circle" @click="folderModel2=true">添加目录</Button>
                        <br><br>
                        <Table stripe :columns="columns1" :data="data1"></Table>


                    </Drawer>
                    <Drawer 　placement="left"  　:closable="false"　width="50%" v-model="folderModel2">
                        <br> <br>
                        <Form :model="formItem" :label-width="80">
                            <FormItem label="目录名">
                                <Input v-model="formItem.input" placeholder="Enter something..."></Input>
                            </FormItem>
                            <FormItem label="上级目录">
                                <Select v-model="formItem.select">
                                    <Option value="beijing">New York</Option>
                                    <Option value="shanghai">London</Option>
                                    <Option value="shenzhen">Sydney</Option>
                                </Select>
                            </FormItem>
                        </Form>
                    </Drawer>
                    <Drawer placement="left"   :closable="false" v-model="pageModel" width="50%">
                        <span style="margin-right: 10px">标题</span> <Input placeholder="标题"style="width: 200px"/>
                        <span style="margin-right: 10px;margin-left: 20px">目录</span><Cascader :data="data" v-model="value1" style="width: 200px;display: inline-block"></Cascader>
                        <br> <br>
                        <!--            <vue-simple-markdown :source="value"></vue-simple-markdown>-->
                        <!--            <mavon-editor v-model="value"/>-->
                        <markdown-editor v-model="value"　:configs="configs" ref="markdownEditor"></markdown-editor>
                        <div class="demo-drawer-footer">
                            <Button style="margin-right: 8px" @click="pageModel = false">取消</Button>
                            <Button type="primary" @click="pageModel = false">保存</Button>
                        </div>
                    </Drawer>
                    <div class="author-ctl">
                        <Tooltip content="编辑" placement="right">
                            <Icon type="ios-create-outline" size="30" />
                        </Tooltip>
                        <br><br>
                        <div>
                            <Poptip placement="left"
                                    trigger="hover"
                                   >
                                    <Icon type="ios-trash-outline"  size="30"/>

                                    <div slot="content">
                                        Are you sure you want to delete this item?
                                    </div>

                            </Poptip>
                        </div>


                    </div>
                </Layout>
            </Content>
        </Layout>
    </Layout>
</template>
<script>
    export default {
        data() {
            return {
                activeMenuName: '1',
                isCollapsed: false,
                folderModel: false,
                folderModel2: false,
                pageModel: false,
                value: '# hello \n' +
                    '> 你好',
                configs: {},
                value1:[],
                data:[{
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
                columns1: [
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
                data1: [
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
                formItem: {
                    input: '',
                    select: '',
                    radio: 'male',
                    checkbox: [],
                    switch: true,
                    date: '',
                    time: '',
                    slider: [20, 50],
                    textarea: ''
                }
            }
        },
        methods: {
            openFolderDrawer() {
                this.folderModel = true
            },
            openPageDrawer() {
                this.pageModel = true
            }
        },
        computed: {
            menuitemClasses: function () {
                return [
                    'menu-item',
                    this.isCollapsed ? 'collapsed-menu' : ''
                ]
            }
        }
    }
</script>