# NavDataPicker


一个可以高度自定义的日期控件,A custom calendar


使用RecyclerView来实现日历的展示,可扩展性以及复用效果较好

**使用方法**:
    Step 1:
        引入库:
        project的build.gradle文件中
        
    allprojects {
 	    repositories {
 	        ...
 	        maven { url 'https://jitpack.io' }
        }
 	}
        
  module中的build.gradle
  
    dependencies {
  	    compile 'com.github.zj8331182:NavDataPicker:v1.0.0'
  	}
  这个不多说
  
  Step 2:<br/>
     <t/><t/>布局文件中使用NavDataPicker<br/>
     <t/><t/>自己定义自己的Adapter继承自BaseNavDataPickerAdapter<br/>
     <t/><t/>Adapter的使用方法和RecyclerView的使用方法是一样<br/>
  Step 3:<br/>
     <t/><t/>Adapter的数据使用NavDateUtil中的getNavDateRange方法获取原始的数据<br/>
     <t/><t/>可以自己对数据进行加工,支持泛型,然后自己在自定义的Adapter中对数据进行展示<br/>
     <br/>
 **效果图**
   <img />
     

