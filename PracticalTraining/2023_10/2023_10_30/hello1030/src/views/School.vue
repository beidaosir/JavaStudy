<template>
    <div>
        <h2 class="stitle">{{ schoolName }}</h2>
    </div>
</template>

<script>
export default{
    name:'School',
    data() {
        return {
            schoolName:'河南师范大学'
        }
    },
}
</script>

<style>
.stitle{
    color: red;
}
</style>