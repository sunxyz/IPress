<style scoped lang="less">
    .layout-con {
        height: 100%;
        width: 100%;
    }

    .menu-item span {
        display: inline-block;
        overflow: hidden;
        width: 69px;
        text-overflow: ellipsis;
        white-space: nowrap;
        vertical-align: bottom;
        transition: width .2s ease .2s;
    }

    .menu-item i {
        transform: translateX(0px);
        transition: font-size .2s ease, transform .2s ease;
        vertical-align: middle;
        font-size: 16px;
    }

    .collapsed-menu span {
        width: 0px;
        transition: width .2s ease;
    }

    .collapsed-menu i {
        transform: translateX(5px);
        transition: font-size .2s ease .2s, transform .2s ease .2s;
        vertical-align: middle;
        font-size: 22px;
    }

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
        &>li{
            margin: 20px;
        }
    }
</style>
<style>
    .ivu-layout-sider-trigger {
        color: #515a6e;
        background: #fff;
        border-right: 1px solid #e6e6e6;
    }

    .ivu-menu {
        position: static;
    }
</style>
<template>
    <div class="layout">
        <Layout :style="{minHeight: '100vh'}">
            <Sider collapsible :collapsed-width="78" v-model="isCollapsed" :width="300" :style="{background: '#fff'}">
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
                                <Tooltip content="新建目录" placement="left">
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
                    <h2 style="cursor: pointer" @click="$router.push({name:'home'})">IPress</h2>
                    <div class="ctrl">
                        <ul>
                            <li>
                                <Tooltip content="新建目录" placement="right">
                                    <Button shape="circle" type="primary" icon="ios-folder-outline"
                                            @click="openFolderDrawer"></Button>
                                </Tooltip>
                            </li>
                            <li>
                                <Tooltip content="新建页面" placement="right">
                                    <Button shape="circle" type="primary" icon="ios-add" @click="openPageDrawer"></Button>
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

            </Sider>

            <Layout>

                <Content :style="{padding: '0 16px 16px'}">

                    <Card>
                        <div style="height: 600px">Content</div>
                    </Card>
                </Content>
            </Layout>
        </Layout>

        <Drawer title="新建目录" placement="left" :closable="false" v-model="folderModel" width="33%">
            <p>Some contents...</p>
            <p>Some contents...</p>
            <p>Some contents...</p>
            <div class="demo-drawer-footer">
                <Button style="margin-right: 8px" @click="folderModel = false">Cancel</Button>
                <Button type="primary" @click="folderModel = false">Submit</Button>
            </div>
        </Drawer>
        <Drawer title="新建页面" placement="right-end" :closable="false" v-model="pageModel" width="100%">
            <p>Some contents...</p>
            <p>Some contents...</p>
            <p>Some contents...</p>
            <div class="demo-drawer-footer">
                <Button style="margin-right: 8px" @click="pageModel = false">Cancel</Button>
                <Button type="primary" @click="pageModel = false">Submit</Button>
            </div>
        </Drawer>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                activeMenuName: '1',
                isCollapsed: false,
                folderModel: false,
                pageModel: false
            };
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