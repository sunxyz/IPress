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
            <div>
                <MainSide
                        :collapsed="isCollapsed"
                        v-bind="$attrs"
                        v-on="$listeners"
                ></MainSide>
            </div>
        </Sider>
        <Layout>
            <Content class="main-content-con">
                <Layout class="main-layout-con">
                    <Content class="content-wrapper">
                        <Card style="min-height: 100%;width: 100%">
                            <slot>
                            </slot>
                        </Card>
                    </Content>
                </Layout>
            </Content>
        </Layout>
    </Layout>
</template>

<script>
    import MainSide from './components/MainSide'
    export default {
        name: "Main",
        data(){
            return{
                isCollapsed:false,
            }
        },
        components:{
            MainSide
        },
        mounted() {

        }
    }
</script>

<style lang="less">
    @import "main.less";
    @import "cover-iview.less";
</style>