<template>
    <div>
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
</template>

<script>
    export default {
        name: "MainCtl"
    }
</script>

<style scoped>

</style>