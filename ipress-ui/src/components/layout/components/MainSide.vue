<template>
    <div>
        <div v-show="!collapsed">
            <div class="side-menu-ctl" >
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
            <Menu width="auto" :class="menuitemClasses">
                <MainSideMenu :menus="menuList"></MainSideMenu>
            </Menu>
        </div>
        <div v-show="collapsed" style="text-align: center;padding: 5px">
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

                <Dropdown placement="right-start" ref="dropdown" v-for="item in menuList">
                    <Icon type="ios-folder-outline" size="26"
                          style="cursor: pointer; margin-right: 30px"></Icon>

                    <DropdownMenu slot="list">
                        <template v-for="obj in item.children">
                            <MainSideDropdown v-if="obj.children" :menu="obj"></MainSideDropdown>
                            <DropdownItem v-else　>
                                <div>
                                    <Icon type="ios-document-outline" />　{{item.name}}
                                </div>
                            </DropdownItem>
                        </template>
                    </DropdownMenu>
                </Dropdown>
            </div>
        </div>
    </div>
</template>

<script>
    import MainSideMenu from './MainSideMenu'
    import MainSideDropdown from './MainSideDropdown'
    export default {
        name: "MainSide",
        components:{
            MainSideMenu,
            MainSideDropdown
        },
        props: {
            collapsed: {
                default: true,
                type: Boolean
            },
            menuList: {
                type: Array,
                default () {
                    return [
                        {
                            id:'1',
                            name:'1',
                            children:[
                                {
                                    id:'1-1',
                                    name:'1-1'
                                },
                                {
                                    id:'1-2',
                                    name:'1-2'
                                },
                                {
                                    id:'1-3',
                                    name:'1-3',
                                    children:[
                                        {
                                            id:'1-3-1',
                                            name:'1-3-1',
                                        }
                                    ]
                                }
                            ]
                        }
                    ]
                }
            },
            showFolderDrawer:{
                default: false,
                type:Boolean
            },
            showPageDrawer:{
                default: false,
                type:Boolean
            }
        },
        computed: {
            menuitemClasses: function () {
                return [
                    'menu-item',
                    this.isCollapsed ? 'collapsed-menu' : ''
                ]
            }
        },
        methods:{
            openFolderDrawer(){
                this.$emit('update:showFolderDrawer', true)
            },
            openPageDrawer(){
                this.$emit('update:showPageDrawer', true)
            }
        }
    }
</script>
<style scoped lang="less">
    .ctrl>ul{
        list-style: none;
        text-align: center;
        &>li{
            margin: 20px ;
        }
    }
    .ctrl>.ivu-dropdown{
        margin: 10px 20px;
        text-align: center;

    }
    .side-menu-ctl{
        margin: 20px;
        box-sizing: border-box
    }
</style>