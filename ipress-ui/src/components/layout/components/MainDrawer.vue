<template>
    <div>
        <Drawer
                placement="left"
                :closable="false"
                :value="showFolderDrawer"
                @on-close="closeFolderDrawer"
                width="50%">
            <slot name="folder-manager"></slot>
        </Drawer>
        <Drawer 　
                :closable="false"　
                width="50%"
                :value="showFolderDrawer2"
                @on-close="closeFolderDrawer2">
            <slot name="folder-form">

            </slot>
        </Drawer>
        <Drawer
                placement="left"
                :closable="false"
                :value="showPageDrawer"
                @on-close="closePageDrawer"
                width="50%">
            <slot name="page">

            </slot>
        </Drawer>
    </div>
</template>

<script>
    export default {
        name: "MainDrawer",
        props:{
            showFolderDrawer:{
                type:Boolean,
                default:false,
            },
            showFolderDrawer2:{
                type:Boolean,
                default:false,
            },
            showPageDrawer:{
                type:Boolean,
                default:false,
            }
        },
        methods:{
            closeFolderDrawer(){
                this.$emit('update:showFolderDrawer', false)
            },
            closeFolderDrawer2(){
                this.$emit('update:showFolderDrawer2', false)
            },
            closePageDrawer(){
                this.$emit('update:showPageDrawer', false)
            }
        }
    }
</script>
