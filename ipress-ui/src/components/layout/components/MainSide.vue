<template>
    <div>
        <template v-if="collapsed">
            <div class="side-ctl-wrapper">
                <h2 class="logo" @click="$router.push({name:'home'})">IPress</h2>
                <div class="ctrl-group">
                    <ul>
                        <li>
                            <Tooltip content="新建页面" placement="right">
                                <Button shape="circle" type="primary" icon="ios-add" @click="clickEntry" ></Button>
                            </Tooltip>

                        </li>
                        <li>
                            <Tooltip content="新建/管理目录" placement="right">
                                <Button shape="circle" type="primary" icon="ios-folder-outline" @click="clickFolder"
                                ></Button>
                            </Tooltip>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="side-menu-wrapper">
                <Dropdown placement="right-start"  v-for="item in menus"　@on-click="selectMenu">
                    <DropdownItem>
                    <Icon type="ios-folder-outline" size="26"
                          style="cursor: pointer; margin:0 10px"></Icon>
                    </DropdownItem>

                    <DropdownMenu slot="list" v-if="item.children.length">
                        <template v-for="obj in item.children">
                            <template v-if="obj.children">
                                <MainSideDropdown v-if="obj.children.length"  :menu="obj"></MainSideDropdown>
                            </template>

                            <DropdownItem v-else :name="obj.id">
                                <div>
                                    <Icon type="ios-document-outline" />　{{obj.name}}
                                </div>
                            </DropdownItem>
                        </template>
                    </DropdownMenu>
                </Dropdown>
            </div>
        </template>
        <template v-else>
            <div class="side-ctl-wrapper">
                <h2 class="logo" @click="$router.push({name:'home'})">IPress</h2>
                <div class="side-ctrl-group">
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
                                        style="margin: 5px 8px" @click="clickFolder"></Button>
                            </Tooltip>
                            <Tooltip content="新建页面" placement="right">
                                <Button shape="circle" type="primary" icon="ios-add" style="margin: 5px  0 5px 8px"  @click="clickEntry"
                                ></Button>
                            </Tooltip>
                        </div>
                    </div>
                </div>

            </div>

            <Menu
                    class="side-menu-wrapper"
                    width="auto"
                    :class="menuitemClasses"
                    :open-names="menuOpenedIds"
                    :active-name="menuActiveId" @on-select="selectMenu"　ref="menu">
                <MainSideSubmenu :menus="menus"></MainSideSubmenu>
            </Menu>
        </template>
    </div>
</template>

<script>
    import MainSideSubmenu from './MainSideSubmenu'
    import MainSideDropdown from './MainSideDropdown'

    export default {
        name: "MainSide",
        components:{
            MainSideSubmenu,
            MainSideDropdown
        },
        props: {
            menus:{
                type:Array
            },
            collapsed: {
                type: Boolean,
                default: false
            },
            menuActiveId:{
                type:String
            },
            menuOpenedIds:{
                type:Array
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
            selectMenu(id){
                if(id){
                    this.$emit('on-select',id)
                }
            },
            clickFolder(){
                this.$emit('on-click-folder')
            },
            clickEntry(){
                this.$emit('on-click-entry')
            }

        },
        watch:{
            menuOpenedIds(){
                this.$nextTick(()=>{
                    this.$refs.menu.updateOpened()
                })
            }
        }
    }
</script>

<style scoped lang="less">
    .logo {
        cursor: pointer;
    }

    .ctrl-group {
        ul li {
            padding-top: 15px;

            &:last-child {
                padding-bottom: 10px;
            }
        }
    }

    .side-ctrl-group {
        padding: 20px;
    }

    .side-ctl-wrapper {
        text-align: center;
        padding-top: 15px;
    }

</style>