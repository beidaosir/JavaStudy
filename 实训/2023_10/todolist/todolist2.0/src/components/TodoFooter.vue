<template>
    <div>
        完成{{ doneTotal }}个/总共{{ listlen }}个
    </div>
</template>


<script>

export default {
    name: 'TodoFooter',
    data() {
        return {
            
        }
    },
    props:['doneTotal','listlen']
}
</script>

<style></style>