(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-78958ad1"],{"057f":function(t,e,r){var n=r("fc6a"),i=r("241c").f,o={}.toString,c="object"==typeof window&&window&&Object.getOwnPropertyNames?Object.getOwnPropertyNames(window):[],s=function(t){try{return i(t)}catch(e){return c.slice()}};t.exports.f=function(t){return c&&"[object Window]"==o.call(t)?s(t):i(n(t))}},"159b":function(t,e,r){var n=r("da84"),i=r("fdbc"),o=r("17c2"),c=r("9112");for(var s in i){var a=n[s],u=a&&a.prototype;if(u&&u.forEach!==o)try{c(u,"forEach",o)}catch(f){u.forEach=o}}},"17c2":function(t,e,r){"use strict";var n=r("b727").forEach,i=r("a640"),o=i("forEach");t.exports=o?[].forEach:function(t){return n(this,t,arguments.length>1?arguments[1]:void 0)}},"1dde":function(t,e,r){var n=r("d039"),i=r("b622"),o=r("2d00"),c=i("species");t.exports=function(t){return o>=51||!n((function(){var e=[],r=e.constructor={};return r[c]=function(){return{foo:1}},1!==e[t](Boolean).foo}))}},"4de4":function(t,e,r){"use strict";var n=r("23e7"),i=r("b727").filter,o=r("1dde"),c=o("filter");n({target:"Array",proto:!0,forced:!c},{filter:function(t){return i(this,t,arguments.length>1?arguments[1]:void 0)}})},5530:function(t,e,r){"use strict";r.d(e,"a",(function(){return o}));r("b64b"),r("a4d3"),r("4de4"),r("e439"),r("159b"),r("dbb4");function n(t,e,r){return e in t?Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}):t[e]=r,t}function i(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,n)}return r}function o(t){for(var e=1;e<arguments.length;e++){var r=null!=arguments[e]?arguments[e]:{};e%2?i(Object(r),!0).forEach((function(e){n(t,e,r[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(r)):i(Object(r)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(r,e))}))}return t}},"65f0":function(t,e,r){var n=r("861d"),i=r("e8b5"),o=r("b622"),c=o("species");t.exports=function(t,e){var r;return i(t)&&(r=t.constructor,"function"!=typeof r||r!==Array&&!i(r.prototype)?n(r)&&(r=r[c],null===r&&(r=void 0)):r=void 0),new(void 0===r?Array:r)(0===e?0:e)}},"70bb":function(t,e,r){"use strict";r.d(e,"a",(function(){return i})),r.d(e,"c",(function(){return o})),r.d(e,"b",(function(){return c}));var n=r("b775"),i=function(){return n["a"].post("/v1/config/addConfig")},o=function(){return n["a"].post("/v1/config/submit")},c=function(){return n["a"].get("/v1/config/getSubmitUser")}},"746f":function(t,e,r){var n=r("428f"),i=r("5135"),o=r("e538"),c=r("9bf2").f;t.exports=function(t){var e=n.Symbol||(n.Symbol={});i(e,t)||c(e,t,{value:o.f(t)})}},"762d":function(t,e,r){"use strict";r.d(e,"b",(function(){return i})),r.d(e,"a",(function(){return o})),r.d(e,"c",(function(){return c})),r.d(e,"e",(function(){return s})),r.d(e,"d",(function(){return a}));var n=r("b775"),i=function(){return n["a"].get("/v1/user/findByClassId")},o=function(t){return n["a"].post("/v1/user/addIntegral",t)},c=function(t){return n["a"].post("/v1/work/findStudentWork",t)},s=function(t,e){return n["a"].get("/v1/work/submitWork/"+t+"/"+e)},a=function(t){return n["a"].get("/v1/user/resetGScoreByGroupId/"+t)}},"7db0":function(t,e,r){"use strict";var n=r("23e7"),i=r("b727").find,o=r("44d2"),c="find",s=!0;c in[]&&Array(1)[c]((function(){s=!1})),n({target:"Array",proto:!0,forced:s},{find:function(t){return i(this,t,arguments.length>1?arguments[1]:void 0)}}),o(c)},8418:function(t,e,r){"use strict";var n=r("c04e"),i=r("9bf2"),o=r("5c6c");t.exports=function(t,e,r){var c=n(e);c in t?i.f(t,c,o(0,r)):t[c]=r}},"8f62":function(t,e,r){"use strict";r("d6ee")},a4d3:function(t,e,r){"use strict";var n=r("23e7"),i=r("da84"),o=r("d066"),c=r("c430"),s=r("83ab"),a=r("4930"),u=r("fdbf"),f=r("d039"),l=r("5135"),d=r("e8b5"),p=r("861d"),b=r("825a"),v=r("7b0b"),g=r("fc6a"),h=r("c04e"),m=r("5c6c"),y=r("7c73"),w=r("df75"),O=r("241c"),I=r("057f"),S=r("7418"),j=r("06cf"),k=r("9bf2"),_=r("d1e7"),x=r("9112"),C=r("6eeb"),A=r("5692"),P=r("f772"),R=r("d012"),E=r("90e3"),N=r("b622"),$=r("e538"),G=r("746f"),z=r("d44e"),D=r("69f3"),U=r("b727").forEach,B=P("hidden"),M="Symbol",J="prototype",F=N("toPrimitive"),L=D.set,W=D.getterFor(M),T=Object[J],H=i.Symbol,Q=o("JSON","stringify"),q=j.f,K=k.f,V=I.f,X=_.f,Y=A("symbols"),Z=A("op-symbols"),tt=A("string-to-symbol-registry"),et=A("symbol-to-string-registry"),rt=A("wks"),nt=i.QObject,it=!nt||!nt[J]||!nt[J].findChild,ot=s&&f((function(){return 7!=y(K({},"a",{get:function(){return K(this,"a",{value:7}).a}})).a}))?function(t,e,r){var n=q(T,e);n&&delete T[e],K(t,e,r),n&&t!==T&&K(T,e,n)}:K,ct=function(t,e){var r=Y[t]=y(H[J]);return L(r,{type:M,tag:t,description:e}),s||(r.description=e),r},st=u?function(t){return"symbol"==typeof t}:function(t){return Object(t)instanceof H},at=function(t,e,r){t===T&&at(Z,e,r),b(t);var n=h(e,!0);return b(r),l(Y,n)?(r.enumerable?(l(t,B)&&t[B][n]&&(t[B][n]=!1),r=y(r,{enumerable:m(0,!1)})):(l(t,B)||K(t,B,m(1,{})),t[B][n]=!0),ot(t,n,r)):K(t,n,r)},ut=function(t,e){b(t);var r=g(e),n=w(r).concat(bt(r));return U(n,(function(e){s&&!lt.call(r,e)||at(t,e,r[e])})),t},ft=function(t,e){return void 0===e?y(t):ut(y(t),e)},lt=function(t){var e=h(t,!0),r=X.call(this,e);return!(this===T&&l(Y,e)&&!l(Z,e))&&(!(r||!l(this,e)||!l(Y,e)||l(this,B)&&this[B][e])||r)},dt=function(t,e){var r=g(t),n=h(e,!0);if(r!==T||!l(Y,n)||l(Z,n)){var i=q(r,n);return!i||!l(Y,n)||l(r,B)&&r[B][n]||(i.enumerable=!0),i}},pt=function(t){var e=V(g(t)),r=[];return U(e,(function(t){l(Y,t)||l(R,t)||r.push(t)})),r},bt=function(t){var e=t===T,r=V(e?Z:g(t)),n=[];return U(r,(function(t){!l(Y,t)||e&&!l(T,t)||n.push(Y[t])})),n};if(a||(H=function(){if(this instanceof H)throw TypeError("Symbol is not a constructor");var t=arguments.length&&void 0!==arguments[0]?String(arguments[0]):void 0,e=E(t),r=function(t){this===T&&r.call(Z,t),l(this,B)&&l(this[B],e)&&(this[B][e]=!1),ot(this,e,m(1,t))};return s&&it&&ot(T,e,{configurable:!0,set:r}),ct(e,t)},C(H[J],"toString",(function(){return W(this).tag})),C(H,"withoutSetter",(function(t){return ct(E(t),t)})),_.f=lt,k.f=at,j.f=dt,O.f=I.f=pt,S.f=bt,$.f=function(t){return ct(N(t),t)},s&&(K(H[J],"description",{configurable:!0,get:function(){return W(this).description}}),c||C(T,"propertyIsEnumerable",lt,{unsafe:!0}))),n({global:!0,wrap:!0,forced:!a,sham:!a},{Symbol:H}),U(w(rt),(function(t){G(t)})),n({target:M,stat:!0,forced:!a},{for:function(t){var e=String(t);if(l(tt,e))return tt[e];var r=H(e);return tt[e]=r,et[r]=e,r},keyFor:function(t){if(!st(t))throw TypeError(t+" is not a symbol");if(l(et,t))return et[t]},useSetter:function(){it=!0},useSimple:function(){it=!1}}),n({target:"Object",stat:!0,forced:!a,sham:!s},{create:ft,defineProperty:at,defineProperties:ut,getOwnPropertyDescriptor:dt}),n({target:"Object",stat:!0,forced:!a},{getOwnPropertyNames:pt,getOwnPropertySymbols:bt}),n({target:"Object",stat:!0,forced:f((function(){S.f(1)}))},{getOwnPropertySymbols:function(t){return S.f(v(t))}}),Q){var vt=!a||f((function(){var t=H();return"[null]"!=Q([t])||"{}"!=Q({a:t})||"{}"!=Q(Object(t))}));n({target:"JSON",stat:!0,forced:vt},{stringify:function(t,e,r){var n,i=[t],o=1;while(arguments.length>o)i.push(arguments[o++]);if(n=e,(p(e)||void 0!==t)&&!st(t))return d(e)||(e=function(t,e){if("function"==typeof n&&(e=n.call(this,t,e)),!st(e))return e}),i[1]=e,Q.apply(null,i)}})}H[J][F]||x(H[J],F,H[J].valueOf),z(H,M),R[B]=!0},a640:function(t,e,r){"use strict";var n=r("d039");t.exports=function(t,e){var r=[][t];return!!r&&n((function(){r.call(null,e||function(){throw 1},1)}))}},b0c0:function(t,e,r){var n=r("83ab"),i=r("9bf2").f,o=Function.prototype,c=o.toString,s=/^\s*function ([^ (]*)/,a="name";n&&!(a in o)&&i(o,a,{configurable:!0,get:function(){try{return c.call(this).match(s)[1]}catch(t){return""}}})},b64b:function(t,e,r){var n=r("23e7"),i=r("7b0b"),o=r("df75"),c=r("d039"),s=c((function(){o(1)}));n({target:"Object",stat:!0,forced:s},{keys:function(t){return o(i(t))}})},b727:function(t,e,r){var n=r("0366"),i=r("44ad"),o=r("7b0b"),c=r("50c4"),s=r("65f0"),a=[].push,u=function(t){var e=1==t,r=2==t,u=3==t,f=4==t,l=6==t,d=7==t,p=5==t||l;return function(b,v,g,h){for(var m,y,w=o(b),O=i(w),I=n(v,g,3),S=c(O.length),j=0,k=h||s,_=e?k(b,S):r||d?k(b,0):void 0;S>j;j++)if((p||j in O)&&(m=O[j],y=I(m,j,w),t))if(e)_[j]=y;else if(y)switch(t){case 3:return!0;case 5:return m;case 6:return j;case 2:a.call(_,m)}else switch(t){case 4:return!1;case 7:a.call(_,m)}return l?-1:u||f?f:_}};t.exports={forEach:u(0),map:u(1),filter:u(2),some:u(3),every:u(4),find:u(5),findIndex:u(6),filterOut:u(7)}},bb51:function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"home"},[r("el-row",{attrs:{gutter:10}},[r("el-col",{staticClass:"left",attrs:{span:19}},[r("ul",{staticClass:"groups"},t._l(t.list,(function(e,n){return r("li",{key:e.groupId,staticClass:"group_item",class:{group_active:n==t.groupActive}},[0===n||1===n||2===n?r("el-badge",{class:{activeBd1:0===n,activeBd2:1===n,activeBd3:2===n},attrs:{value:n+1,type:"primary"}},[r("div",{staticClass:"groupsName"},[r("span",[t._v(t._s(e.groupName))]),t._v(" : 共计 "),r("span",[t._v(t._s(e.groupsIntegral))]),t._v(" 分 ： ")])]):r("div",{staticClass:"groupsName"},[r("span",[t._v(t._s(e.groupName))]),t._v(" : 共计 "),r("span",[t._v(t._s(e.groupsIntegral))]),t._v(" 分 ： ")]),t._l(e.children,(function(e,i){return r("el-tag",{key:e.id,staticClass:"students_item",class:{active:i===t.active},attrs:{effect:"dark"},on:{click:function(e){return t.setStudents(n,i)}}},[t._v(" "+t._s(e.name)+" ")])}))],2)})),0)]),r("el-col",{staticClass:"right",staticStyle:{height:"100%"},attrs:{span:5}},[r("div",{staticClass:"import"}),r("el-divider",{attrs:{"content-position":"left"}},[t._v("上传班级信息")]),r("div",{staticClass:"upload-button"},[r("el-upload",{staticClass:"upload-demo",attrs:{action:t.importUser,headers:t.headersObj,"on-success":t.onClassNumberSuccess,multiple:""}},[r("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary"}},[t._v("上传学员账号")])],1),r("el-upload",{staticClass:"upload-demo",attrs:{action:t.actionUrlImportGroup,headers:t.headersObj,"on-success":t.onClassGroupsSuccess,multiple:""}},[r("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary"}},[t._v("上传班级小组")])],1),r("el-button",{staticStyle:{width:"100%"},attrs:{type:"warning"},on:{click:t.exportStudentsExcel}},[t._v("导出学员账号")])],1),r("el-divider",{attrs:{"content-position":"left"}},[t._v("抽选提问")]),r("el-button",{staticStyle:{width:"100%"},attrs:{disabled:t.isStart,type:"primary"},on:{click:t.selection}},[t._v(" 提问 ")]),r("el-button",{staticStyle:{background:"#C00000",margin:"10px 0",width:"100%"},attrs:{disabled:t.isRush,type:"danger"},on:{click:t.startRush}},[t._v(" "+t._s(t.isRush?"抢答中":"开始抢答")+" ")]),r("el-input-number",{staticStyle:{margin:"10px 0px",width:"100%"},model:{value:t.number,callback:function(e){t.number=e},expression:"number"}}),r("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary"},on:{click:function(e){return t.confirmIntegral(t.number)}}},[t._v(" 确认积分 ")]),r("el-button",{staticClass:"reset-btn",attrs:{type:"warning"},on:{click:t.reset}},[t._v("重置班级小组积分")]),r("el-divider",{attrs:{"content-position":"left"}},[t._v("快速加减积分")]),r("div",{staticClass:"addNum"},[r("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.confirmIntegral(2)}}},[t._v("+2")]),r("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.confirmIntegral(5)}}},[t._v("+5")]),r("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.confirmIntegral(10)}}},[t._v("+10")]),r("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.confirmIntegral(20)}}},[t._v("+20")])],1),r("div",{staticClass:"subNum"},[r("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.confirmIntegral(-2)}}},[t._v("- 2")]),r("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.confirmIntegral(-5)}}},[t._v("- 5")]),r("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.confirmIntegral(-10)}}},[t._v("- 10")]),r("el-button",{attrs:{size:"mini"},on:{click:function(e){return t.confirmIntegral(-20)}}},[t._v("- 20")])],1)],1)],1)],1)},i=[],o=r("5530"),c=r("1da1"),s=(r("96cf"),r("159b"),r("7db0"),r("b0c0"),r("c740"),r("762d")),a=r("70bb"),u={name:"Home",data:function(){return{list:[],groupActive:0,active:0,setId:null,number:1,leftLoading:!1,isStart:!1,isRush:!1,headersObj:{token:localStorage.getItem("hmhz-intergral-token")},actionUrlImportGroup:location.protocol+"//"+location.host+"/v1/group/importGroup",importUser:location.protocol+"//"+location.host+"/v1/user/importUser"}},created:function(){console.log(this.$router),this.getGroups()},methods:{onClassNumberSuccess:function(t){0===t.code&&this.$message.success("导入成功")},onClassGroupsSuccess:function(t){0===t.code&&(this.$message.success("导入成功"),this.getGroups())},getGroups:function(){var t=this;return Object(c["a"])(regeneratorRuntime.mark((function e(){var r,n,i;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.leftLoading=!0,e.next=3,Object(s["b"])(t.$store.state.classId);case 3:if(r=e.sent,n=r.data,0===n.code){e.next=7;break}return e.abrupt("return",t.$message("获取失败"));case 7:i=[],n.data.forEach((function(t,e){var r=i.find((function(e){return e.groupId===t.groupId}));r?r.children?r.children.push(t):r.children=[t]:i.push(Object(o["a"])(Object(o["a"])({},t),{},{children:[t]}))})),t.leftLoading=!1,t.list=i.sort((function(t,e){return e.groupsIntegral-t.groupsIntegral}));case 11:case"end":return e.stop()}}),e)})))()},selection:function(){var t=this,e=0;this.setId=setInterval((function(){if(e++,50===e)return clearInterval(t.setId);var r=Math.floor(Math.random()*t.list.length),n=Math.floor(Math.random()*t.list[r].children.length);t.groupActive=r,t.active=n}),50)},confirmIntegral:function(t){var e=this;return Object(c["a"])(regeneratorRuntime.mark((function r(){var n,i,o,c,a,u,f;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:return n=e.list[e.groupActive].children[e.active],i=n.id,o=n.name,r.next=3,Object(s["a"])({id:i,integral:t});case 3:if(c=r.sent,a=c.data,e.list[e.groupActive].groupsIntegral+=t,e.list[e.groupActive].children[e.active].integral+=t,u=e.list[e.groupActive].groupId,console.log(u),e.list.sort((function(t,e){return e.groupsIntegral-t.groupsIntegral})),f=e.list.findIndex((function(t){return t.groupId===u})),e.setStudents(f,e.active),0===a.code){r.next=14;break}return r.abrupt("return",e.$message("添加失败"));case 14:if(!(t>0)){r.next=16;break}return r.abrupt("return",e.$message.success("恭喜🎉🎉🎉🎉🎉🎉"+o+"同学，回答正确！为第"+(e.groupActive+1)+"组赢得"+t+"积分"));case 16:e.$message.error("同学，要认真观看视频了呦！😫😫😫😫，争取下次赢得积分，本次扣除第"+(e.groupActive+1)+"组"+Math.abs(t)+"积分");case 17:case"end":return r.stop()}}),r)})))()},setStudents:function(t,e){this.groupActive=t,this.active=e},startRush:function(){var t=this;return Object(c["a"])(regeneratorRuntime.mark((function e(){var r,n,i,o;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.isRush=!0,e.next=3,Object(a["a"])();case 3:r=e.sent,n=r.data,0===n.code&&(i=0,o=setInterval(Object(c["a"])(regeneratorRuntime.mark((function e(){var r,n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(i++,!(i>4)){e.next=6;break}return clearInterval(o),t.isRush=!1,t.$message("没有同学抢答呦"),e.abrupt("return");case 6:return e.next=8,Object(a["b"])();case 8:r=e.sent,n=r.data,400007!==n.code&&""!==n.data&&null!==n.data&&(clearInterval(o),t.isRush=!1,t.setRushStudents(n));case 11:case"end":return e.stop()}}),e)}))),1e3));case 6:case"end":return e.stop()}}),e)})))()},setRushStudents:function(t){var e=this;console.log(t.data),console.log(this.list);var r=null;this.list.find((function(n,i){var o=n.children.find((function(n,i){return n.id===t.data-0&&(r=n,e.active=i,!0)}));return!!o&&(e.groupActive=i,!0)})),this.$message.success("恭喜"+r.name+"抢答成功")},exportStudentsExcel:function(){window.open(location.protocol+"//"+location.host+"/v1/user/exportUser/"+this.list[0].classId)},reset:function(){var t=this;return Object(c["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(s["d"])(t.list[0].classId);case 2:t.$message.success("积分已重置"),t.getGroups();case 4:case"end":return e.stop()}}),e)})))()}}},f=u,l=(r("8f62"),r("2877")),d=Object(l["a"])(f,n,i,!1,null,"616709a1",null);e["default"]=d.exports},c740:function(t,e,r){"use strict";var n=r("23e7"),i=r("b727").findIndex,o=r("44d2"),c="findIndex",s=!0;c in[]&&Array(1)[c]((function(){s=!1})),n({target:"Array",proto:!0,forced:s},{findIndex:function(t){return i(this,t,arguments.length>1?arguments[1]:void 0)}}),o(c)},d6ee:function(t,e,r){},dbb4:function(t,e,r){var n=r("23e7"),i=r("83ab"),o=r("56ef"),c=r("fc6a"),s=r("06cf"),a=r("8418");n({target:"Object",stat:!0,sham:!i},{getOwnPropertyDescriptors:function(t){var e,r,n=c(t),i=s.f,u=o(n),f={},l=0;while(u.length>l)r=i(n,e=u[l++]),void 0!==r&&a(f,e,r);return f}})},e439:function(t,e,r){var n=r("23e7"),i=r("d039"),o=r("fc6a"),c=r("06cf").f,s=r("83ab"),a=i((function(){c(1)})),u=!s||a;n({target:"Object",stat:!0,forced:u,sham:!s},{getOwnPropertyDescriptor:function(t,e){return c(o(t),e)}})},e538:function(t,e,r){var n=r("b622");e.f=n},e8b5:function(t,e,r){var n=r("c6b6");t.exports=Array.isArray||function(t){return"Array"==n(t)}}}]);
//# sourceMappingURL=chunk-78958ad1.328cd5a5.js.map