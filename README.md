# Gold
一个轻量级为View添加阴影效果的类库，支持阴影颜色设置和低版本SDK


### 引入依赖 
在Project的build.gradle在添加以下代码
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
在Module的build.gradle在添加以下代码
```
	implementation 'com.github.zsgfrtttt:Gold:1.0.2'
```
**注意：** 依赖迁移至Androidx

### 基本使用

**仅需一行代码**
```java
  Gold.with(ivTop).colorInt(Color.BLUE).radius(radius).shadowSize(shadow).apply();
```
**可选属性**
```txt
   ColorStateList colorStateList = ColorStateList.valueOf(Color.WHITE);
   float radius;
   float shadowSize;
   float maxShadowSize;
   int shadowStartColor = Integer.MIN_VALUE;
   int shadowEndColor = Integer.MIN_VALUE;
```
