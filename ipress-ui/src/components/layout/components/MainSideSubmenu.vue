<template>
    <div>
        <template v-for="item in menus">
            <template v-if="item.children">
                <Submenu :name="item.id" :key="item.id">
                    <template slot="title">
                        <Icon type="ios-folder-outline"/>
                        {{item.name}}
                    </template>
                    <MainSideMenu :menus="item.children"></MainSideMenu>
                </Submenu>
            </template>
            <template v-else>
                <MenuItem :name="item.id" 　>
                    <Icon type="ios-document-outline"/>
                    {{item.name}}
                </MenuItem>
            </template>
        </template>
    </div>

</template>

<script>
    export default {
        name: 'MainSideMenu',
        props: {
            menus: {
                type:Array
            }
        }
    }
</script>