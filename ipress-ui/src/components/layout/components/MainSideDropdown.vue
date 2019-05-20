<template>
    <Dropdown placement="right-start" >
        <DropdownItem >
            <Icon type="ios-folder-outline"/>
            {{menu.name}}
            <Icon type="ios-arrow-forward"></Icon>
        </DropdownItem>
        <DropdownMenu slot="list" v-if="menu.children.length">
            <template v-for="item in menu.children">
                <template v-if="item.children">
                    <MainSideDropdown 　:menu="item"></MainSideDropdown>
                </template>
                <DropdownItem 　:name="item.id" v-else>　
                        <Icon type="ios-document-outline" />　{{item.name}}

                </DropdownItem>
            </template>
        </DropdownMenu>
    </Dropdown>
</template>

<script>
    export default {
        name: "MainSideDropdown",
        props: {
            menu:{
                type: Object
            }
        }
    }
</script>