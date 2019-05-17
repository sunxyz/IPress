<template>
    <Dropdown placement="right-start">
        <DropdownItem>
            <Icon type="ios-folder-outline"/>
            {{menu.name}}
            <Icon type="ios-arrow-forward"></Icon>
        </DropdownItem>
        <DropdownMenu slot="list">
            <template v-for="item in menu.children">
                <MainSideDropdown v-if="item.children" :menu="item"></MainSideDropdown>
                <DropdownItem v-else>　
                  <div>
                      <Icon type="ios-document-outline" />　{{item.name}}
                  </div>

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