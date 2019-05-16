<template>
  <div class="container">
    <br><br>
    <h1>IPress</h1>
    <br> <br>
    <div class="home">
      <div class="pocket-box">
        <div class="pocket-item" @click="$router.push({name:'pocket'})">标题0001</div>
        <div class="pocket-item">标题0002</div>
        <div class="pocket-item">标题0003</div>
        <div class="pocket-item">标题0004</div>
        <div class="pocket-item">标题0005</div>
        <div class="pocket-item">标题0006</div>
        <div class="pocket-item">标题0007</div>
        <div class="pocket-item">标题0008</div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'home'
}
</script>

<style lang="less">
  .container{
    width: 900px;
    margin: 0 auto;
    text-align: left;
  }

  .pocket-box{
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap:wrap;
  }
  .pocket-item{
    width: 280px;
    height: 160px;
    border:1px solid #eee;
    border-radius: 5px;
    margin-bottom: 30px;
    text-align: center;
    line-height: 160px;
    font-size: 16px;
    color: #777;
    font-weight: 700;
    transition: all .5s ease-in-out;
    &:hover{
     border:1px solid  #2d8cf0;
     cursor: pointer;
    }
  }
</style>
