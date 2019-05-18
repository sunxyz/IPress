<template>
    <Layout
            style="height: 100%"
            class="main">
        <Sider collapsible
               :width="300"
               :collapsed-width="78"
               v-model="isCollapsed"
               class="left-sider"
               :style="{background: '#fff',overflow:''}">
            <div
                    class="side-menu-wrapper">

                <MainSide
                          :collapsed="isCollapsed"
                          :showFolderDrawer="showFolderDrawer"
                          :showPageDrawer="showPageDrawer"
                          :menuList="menuList"
                          @update:showFolderDrawer="updateShowFolderDrawer"
                          @update:showPageDrawer="updateShowPageDrawer"
                />
            </div>
        </Sider>
        <Layout>
            <Content class="main-content-con">
                <Layout class="main-layout-con">
                    <Content class="content-wrapper">
                        <Card style="min-height: 100%;width: 100%">
                            <slot></slot>
                        </Card>
                        <MainDrawer
                                :showFolderDrawer="showFolderDrawer"
                                :showFolderDrawer2="showFolderDrawer2"
                                :showPageDrawer="showPageDrawer"
                                @update:showFolderDrawer="updateShowFolderDrawer"
                                @update:showFolderDrawer2="updateShowFolderDrawer2"
                                @update:showPageDrawer="updateShowPageDrawer"
                                >
                            <div slot="folder-manager">
                                <slot name="folder-manager"></slot>
                            </div>
                            <div slot="folder-form">
                                <slot name="folder-form"></slot>
                            </div>
                            <div slot="page">
                                <slot name="page"></slot>
                            </div>
                        </MainDrawer>
                    </Content>
                    <div class="author-ctl">
                        <MainCtl></MainCtl>
                    </div>
                </Layout>
            </Content>
        </Layout>
    </Layout>
</template>

<script>
    import MainSide from './components/MainSide'
    import MainDrawer from './components/MainDrawer'
    import MainCtl from './components/MainCtl'

    export default {
        name: "Main",
        components: {
            MainSide,
            MainDrawer,
            MainCtl
        },
        props:{
            showFolderDrawer:{
                type:Boolean,
                default:false
            },
            showFolderDrawer2:{
                type:Boolean,
                default:false
            },
            showPageDrawer:{
                type:Boolean,
                default:false
            },
            menuList:{
                type:Array
            }
        },
        data() {
            return {
                isCollapsed: false
            }
        },
        methods:{
            updateShowFolderDrawer(v){
                this.$emit('update:showFolderDrawer', v)
            },
            updateShowFolderDrawer2(v){
                this.$emit('update:showFolderDrawer2', v)
            },
            updateShowPageDrawer(v){
                this.$emit('update:showPageDrawer', v)
            },

        }
    }
</script>

<style lang="less">
    @import "main.less";
    @import "cover-iview.less";
</style>

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