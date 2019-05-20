<template>
  <div class="container">
    <br><br>
    <h1>IPress</h1>
    <br> <br>
    <div class="home">
      <div class="pocket-box">
          <div
                  v-for="pocket in pocketArray" 　
                  :key="pocket.id"　
                  class="pocket-item"
                  @click="$router.push({name:'pocket',params:{id:pocket.id}})"
                  :style="{background: 'url('+pocket.bg+')'}"
                  >
            <div class="setting">
              <Icon type="ios-cog-outline" size="20" @click.stop="openModal(pocket.id, pocket)"/>
            </div>
            <div class="text" v-text="pocket.name">
              标题0001
            </div>

          </div>
          <div class="pocket-item" @click="openModal()">
          <Icon class="text" type="md-add" size="50" />
        </div>
      </div>
    </div>
    <Modal
            :title="modalTitle"
            v-model="modal"
            width="390"
            class-name="vertical-center-modal">
      <Form ref="formCustom" :model="pocket" :rules="ruleCustom" :label-width="80">
        <FormItem label="名称" prop="name">
          <Input type="text" v-model="pocket.name"></Input>
        </FormItem>
        <FormItem label="描述" prop="description">
          <Input type="text" v-model="pocket.description"></Input>
        </FormItem>
        <FormItem label="背景图" prop="bg">
          <Input type="text" v-model="pocket.bg" ></Input>
        </FormItem>
      </Form>
      <div slot="footer">
        <Button @click="modal = false">关闭</Button>
        <Button type="primary" @click="handleSubmit('formCustom')">确定</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
import {list, save, update} from '../api/homeApi'
export default {
  name: 'home',
  data(){
    const validateName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入名称'));
      } else {
        callback();
      }
    }
    return {
      modal:false,
      pocketArray:[],
      pocketId:undefined,
      pocket: {
        name: '',
        description: '',
        bg: ''
      },
      ruleCustom: {
        name: [
          { validator: validateName, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    loadData(){
      list().then(d=>{
        this.pocketArray = d.data
      })
    },
    openModal(id,pocket){
      this.pocketId=id
      this.pocket = Object.assign({
        name: '',
        description: '',
        bg: ''
      },pocket);
      this.modal=true
    },
    handleSubmit (name) {
      this.$refs[name].validate((valid) => {
        if (valid) {
          if(this.pocketId){
            update(this.pocketId, this.pocket).then(()=>{
              this.$Message.success('更新成功');
              this.handleReset('formCustom')
              this.modal=false
              this.loadData()
            })
          }else{
            save(this.pocket).then(()=>{
              this.$Message.success('保存成功');
              this.handleReset('formCustom')
              this.modal=false
              this.loadData()
            })
          }
        }
      })
    },
    handleReset (name) {
      this.$refs[name].resetFields();
    }
  },
  computed:{
    modalTitle(){
      return this.pocketId?'修改':'新增'
    }
  },
  mounted() {
    this.loadData()
  }
}
</script>
<style lang="less">
  .vertical-center-modal{
    display: flex;
    align-items: center;
    justify-content: center;

    .ivu-modal{
      top: 0;
    }
  }
</style>

<style scoped lang="less">

  .container{
    width: 900px;
    margin: 0 auto;
    text-align: left;
  }
  @media  screen and (max-width: 768px) {
    .container{
      width: 100%;
    }
    .container h1{
      text-align: center;
    }
    .container .pocket-box{
      text-align: center;
    }
    .pocket-box .pocket-item{
      width: 160px;
      height: 100px;
      line-height: 100px;
    }
  }

  .pocket-box{
    /*display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap:wrap;*/
    margin: 0 auto;
  }
  .pocket-item{
    width: 280px;
    height: 160px;
    border:1px solid #eee;
    border-radius: 5px;
    margin: 10px;
    text-align: center;
    font-size: 16px;
    color: #f1f1f1;
    font-weight: 700;
    display: inline-block;
    transition: all .5s ease-in-out;
    position: relative;
    .text{
      line-height: 160px;
    }
    .setting{
      display: none;
      position: absolute;
      right: 10px;top: 5px
    }
    &:hover{
      .setting{
        display: block;
      }
     border:1px solid  #2d8cf0;
     cursor: pointer;
    }
  }
</style>
