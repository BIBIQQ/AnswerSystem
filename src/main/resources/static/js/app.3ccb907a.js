(function (e) {
    function t(t) {
        for (var o, r, u = t[0], i = t[1], l = t[2], s = 0, d = []; s < u.length; s++) r = u[s], Object.prototype.hasOwnProperty.call(a, r) && a[r] && d.push(a[r][0]), a[r] = 0;
        for (o in i) Object.prototype.hasOwnProperty.call(i, o) && (e[o] = i[o]);
        f && f(t);
        while (d.length) d.shift()();
        return c.push.apply(c, l || []), n()
    }

    function n() {
        for (var e, t = 0; t < c.length; t++) {
            for (var n = c[t], o = !0, r = 1; r < n.length; r++) {
                var u = n[r];
                0 !== a[u] && (o = !1)
            }
            o && (c.splice(t--, 1), e = i(i.s = n[0]))
        }
        return e
    }

    var o = {}, r = {app: 0}, a = {app: 0}, c = [];

    function u(e) {
        return i.p + "js/" + ({}[e] || e) + "." + {
            "chunk-450f4192": "140ebd7d",
            "chunk-1926971a": "6058b6eb",
            "chunk-33571c14": "4914a5b5",
            "chunk-3582785e": "562f0cc9",
            "chunk-3fd661b4": "5e63ee92",
            "chunk-46a8dabe": "488738b6",
            "chunk-4ec17651": "be7dc03a",
            "chunk-663c6bee": "9aba0fe6",
            "chunk-7f081464": "35af82bd"
        }[e] + ".js"
    }

    function i(t) {
        if (o[t]) return o[t].exports;
        var n = o[t] = {i: t, l: !1, exports: {}};
        return e[t].call(n.exports, n, n.exports, i), n.l = !0, n.exports
    }

    i.e = function (e) {
        var t = [], n = {
            "chunk-1926971a": 1,
            "chunk-33571c14": 1,
            "chunk-3582785e": 1,
            "chunk-3fd661b4": 1,
            "chunk-46a8dabe": 1,
            "chunk-4ec17651": 1,
            "chunk-663c6bee": 1,
            "chunk-7f081464": 1
        };
        r[e] ? t.push(r[e]) : 0 !== r[e] && n[e] && t.push(r[e] = new Promise((function (t, n) {
            for (var o = "css/" + ({}[e] || e) + "." + {
                "chunk-450f4192": "31d6cfe0",
                "chunk-1926971a": "f8960e45",
                "chunk-33571c14": "e1513af0",
                "chunk-3582785e": "8a1192ac",
                "chunk-3fd661b4": "23cc0c80",
                "chunk-46a8dabe": "ee4ec105",
                "chunk-4ec17651": "fa83dc21",
                "chunk-663c6bee": "c3da3874",
                "chunk-7f081464": "00fda3e1"
            }[e] + ".css", a = i.p + o, c = document.getElementsByTagName("link"), u = 0; u < c.length; u++) {
                var l = c[u], s = l.getAttribute("data-href") || l.getAttribute("href");
                if ("stylesheet" === l.rel && (s === o || s === a)) return t()
            }
            var d = document.getElementsByTagName("style");
            for (u = 0; u < d.length; u++) {
                l = d[u], s = l.getAttribute("data-href");
                if (s === o || s === a) return t()
            }
            var f = document.createElement("link");
            f.rel = "stylesheet", f.type = "text/css", f.onload = t, f.onerror = function (t) {
                var o = t && t.target && t.target.src || a,
                    c = new Error("Loading CSS chunk " + e + " failed.\n(" + o + ")");
                c.code = "CSS_CHUNK_LOAD_FAILED", c.request = o, delete r[e], f.parentNode.removeChild(f), n(c)
            }, f.href = a;
            var h = document.getElementsByTagName("head")[0];
            h.appendChild(f)
        })).then((function () {
            r[e] = 0
        })));
        var o = a[e];
        if (0 !== o) if (o) t.push(o[2]); else {
            var c = new Promise((function (t, n) {
                o = a[e] = [t, n]
            }));
            t.push(o[2] = c);
            var l, s = document.createElement("script");
            s.charset = "utf-8", s.timeout = 120, i.nc && s.setAttribute("nonce", i.nc), s.src = u(e);
            var d = new Error;
            l = function (t) {
                s.onerror = s.onload = null, clearTimeout(f);
                var n = a[e];
                if (0 !== n) {
                    if (n) {
                        var o = t && ("load" === t.type ? "missing" : t.type), r = t && t.target && t.target.src;
                        d.message = "Loading chunk " + e + " failed.\n(" + o + ": " + r + ")", d.name = "ChunkLoadError", d.type = o, d.request = r, n[1](d)
                    }
                    a[e] = void 0
                }
            };
            var f = setTimeout((function () {
                l({type: "timeout", target: s})
            }), 12e4);
            s.onerror = s.onload = l, document.head.appendChild(s)
        }
        return Promise.all(t)
    }, i.m = e, i.c = o, i.d = function (e, t, n) {
        i.o(e, t) || Object.defineProperty(e, t, {enumerable: !0, get: n})
    }, i.r = function (e) {
        "undefined" !== typeof Symbol && Symbol.toStringTag && Object.defineProperty(e, Symbol.toStringTag, {value: "Module"}), Object.defineProperty(e, "__esModule", {value: !0})
    }, i.t = function (e, t) {
        if (1 & t && (e = i(e)), 8 & t) return e;
        if (4 & t && "object" === typeof e && e && e.__esModule) return e;
        var n = Object.create(null);
        if (i.r(n), Object.defineProperty(n, "default", {
            enumerable: !0,
            value: e
        }), 2 & t && "string" != typeof e) for (var o in e) i.d(n, o, function (t) {
            return e[t]
        }.bind(null, o));
        return n
    }, i.n = function (e) {
        var t = e && e.__esModule ? function () {
            return e["default"]
        } : function () {
            return e
        };
        return i.d(t, "a", t), t
    }, i.o = function (e, t) {
        return Object.prototype.hasOwnProperty.call(e, t)
    }, i.p = "", i.oe = function (e) {
        throw console.error(e), e
    };
    var l = window["webpackJsonp"] = window["webpackJsonp"] || [], s = l.push.bind(l);
    l.push = t, l = l.slice();
    for (var d = 0; d < l.length; d++) t(l[d]);
    var f = s;
    c.push([0, "chunk-vendors"]), n()
})({
    0: function (e, t, n) {
        e.exports = n("56d7")
    }, "3d7a": function (e, t, n) {
    }, 4360: function (e, t, n) {
        "use strict";
        var o = n("2b0e"), r = n("2f62");
        o["default"].use(r["a"]), t["a"] = new r["a"].Store({
            state: {
                classId: localStorage.getItem("classId") || "",
                isLoading: !1
            }, mutations: {
                setClassId: function (e, t) {
                    e.classId = t, localStorage.setItem("classId", t)
                }, setLoading: function (e, t) {
                    e.isLoading = t
                }
            }, actions: {}, modules: {}
        })
    }, "56d7": function (e, t, n) {
        "use strict";
        n.r(t);
        n("e260"), n("e6cf"), n("cca6"), n("a79d");
        var o = n("2b0e"), r = function () {
                var e = this, t = e.$createElement, n = e._self._c || t;
                return n("div", {
                    directives: [{
                        name: "loading",
                        rawName: "v-loading",
                        value: e.$store.state.isLoading,
                        expression: "$store.state.isLoading"
                    }],
                    attrs: {
                        id: "app",
                        "element-loading-text": "拼命加载中",
                        "element-loading-background": "rgba(255, 255, 255, 0.6)"
                    }
                }, [n("router-view")], 1)
            }, a = [], c = {
                data: function () {
                    return {isLoading: !0}
                }, methods: {}
            }, u = c, i = n("2877"), l = Object(i["a"])(u, r, a, !1, null, null, null), s = l.exports,
            d = (n("d3b7"), n("3ca3"), n("ddb0"), n("8c4f")), f = function () {
                var e = this, t = e.$createElement, n = e._self._c || t;
                return n("div", [n("div", {staticClass: "header"}, [n("p", [e._v("hi~ 老师")]), n("el-menu", {
                    staticClass: "el-menu-demo",
                    attrs: {
                        "text-color": "#000",
                        "active-text-color": "#C00000",
                        "default-active": e.activeIndex,
                        mode: "horizontal",
                        router: ""
                    }
                }, [n("el-menu-item", {attrs: {index: "/home"}}, [e._v("首页")]), n("el-menu-item", {attrs: {index: "/practice"}}, [e._v("练习")]), n("el-menu-item", {attrs: {index: "/task"}}, [e._v("作业")]), n("el-menu-item", {attrs: {index: "/statistics"}}, [e._v("统计")])], 1), n("div", [n("el-select", {
                    attrs: {placeholder: "请选择练习时间/分钟"},
                    model: {
                        value: e.value, callback: function (t) {
                            e.value = t
                        }, expression: "value"
                    }
                }, e._l(e.options, (function (e, t) {
                    return n("el-option", {key: t, attrs: {label: e, value: e}})
                })), 1), n("el-button", {
                    staticStyle: {margin: "0 10px"},
                    on: {click: e.startTask}
                }, [e._v("开始")]), e.countDown > 0 ? n("span", {
                    staticStyle: {
                        width: "200px",
                        display: "inline-block"
                    }
                }, [e._v("距离练习结束还剩：" + e._s(e.countDown) + " 秒")]) : n("span", {
                    staticStyle: {
                        width: "200px",
                        display: "inline-block"
                    }
                }, [e._v("练习未开始或已结束")])], 1), n("el-button", {on: {click: e.logout}}, [e._v("退出")])], 1), n("router-view")], 1)
            }, h = [], m = {
                data: function () {
                    return {
                        activeIndex: this.$route.path,
                        options: [1, 2, 3, 4, 5, 10, 12, 15, 20],
                        value: "",
                        countDown: 0
                    }
                }, created: function () {
                    var e = this;
                    if (localStorage.getItem("countDown")) {
                        var t = localStorage.getItem("countDown"), n = new Date(t);
                        this.countDown = Math.floor((n - new Date) / 1e3), this.id = setInterval((function () {
                            e.countDown--, e.countDown < 0 && (clearInterval(e.id), localStorage.removeItem("countDown", t))
                        }), 1e3)
                    }
                }, methods: {
                    logout: function () {
                        this.$store.commit("setClassId", null), localStorage.removeItem("hmhz-intergral-token"), localStorage.removeItem("classId"), this.$router.push("/login")
                    }, startTask: function () {
                        var e = this;
                        this.id && clearInterval(this.id);
                        var t = new Date(Date.now() + 60 * this.value * 1e3);
                        localStorage.setItem("countDown", t), this.countDown = 60 * this.value, this.id = setInterval((function () {
                            e.countDown--, e.countDown < 0 && (clearInterval(e.id), localStorage.removeItem("countDown", t))
                        }), 1e3)
                    }
                }
            }, p = m, v = (n("84c6"), Object(i["a"])(p, f, h, !1, null, "98885026", null)), b = v.exports, g = function () {
                var e = this, t = e.$createElement, n = e._self._c || t;
                return n("div", [n("my-b", {
                    scopedSlots: e._u([{
                        key: "default", fn: function (t) {
                            var o = t.row;
                            return [n("el-tag", [e._v(e._s(o.name))])]
                        }
                    }])
                })], 1)
            }, k = [], w = function () {
                var e = this, t = e.$createElement, n = e._self._c || t;
                return n("div", [n("ul", e._l(e.list, (function (t) {
                    return n("li", {key: t.id}, [e._t("default", [e._v(" " + e._s(t.name) + " ")], {row: t})], 2)
                })), 0)])
            }, y = [], _ = {
                data: function () {
                    return {list: [{name: "鞋子", id: 1}, {name: "袜子", id: 2}, {name: "裤子", id: 3}]}
                }, beforeCreate: function () {
                    console.log("b-beforeCreate")
                }, created: function () {
                    console.log("b-created")
                }, beforeMount: function () {
                    console.log("b-beforeMount")
                }, mounted: function () {
                    console.log("b-mounted")
                }, methods: {}
            }, x = _, I = Object(i["a"])(x, w, y, !1, null, "b7c7c206", null), S = I.exports, D = {
                data: function () {
                    return {}
                }, beforeCreate: function () {
                    console.log("a-beforeCreate")
                }, created: function () {
                    console.log("a-created")
                }, beforeMount: function () {
                    console.log("a-beforeMount")
                }, mounted: function () {
                    console.log("a-mounted")
                }, components: {"my-b": S}, methods: {}
            }, P = D, C = Object(i["a"])(P, g, k, !1, null, "5911ba70", null), O = C.exports;
        o["default"].use(d["a"]);
        var j = [{path: "/a", component: O}, {path: "/", redirect: "/login"}, {
            path: "/home",
            component: b,
            children: [{
                path: "", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-663c6bee")]).then(n.bind(null, "bb51"))
                }
            }, {
                path: "/practice", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-33571c14")]).then(n.bind(null, "6e16"))
                }
            }, {
                path: "/task", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-3582785e")]).then(n.bind(null, "2434"))
                }
            }, {
                path: "/statistics", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-1926971a")]).then(n.bind(null, "ac67"))
                }
            }]
        }, {
            path: "/login", component: function () {
                return Promise.all([n.e("chunk-450f4192"), n.e("chunk-4ec17651")]).then(n.bind(null, "d9c9"))
            }
        }, {
            path: "/students/home", component: function () {
                return Promise.all([n.e("chunk-450f4192"), n.e("chunk-46a8dabe")]).then(n.bind(null, "c3c1"))
            }, redirect: "/students/practiceList", children: [{
                path: "/students/practiceList", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-7f081464")]).then(n.bind(null, "38f2"))
                }
            }, {
                path: "/students/taskList", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-3fd661b4")]).then(n.bind(null, "ee4c"))
                }
            }]
        }], L = new d["a"]({routes: j}), E = L, T = n("4360"), $ = n("5c96"), M = n.n($);
        n("0fae"), n("845fb"), n("acc7");
        o["default"].use(M.a), o["default"].config.productionTip = !1, new o["default"]({
            router: E,
            store: T["a"],
            render: function (e) {
                return e(s)
            }
        }).$mount("#app")
    }, "845fb": function (e, t, n) {
    }, "84c6": function (e, t, n) {
        "use strict";
        n("3d7a")
    }, acc7: function (e, t, n) {
    }
});
//# sourceMappingURL=app.3ccb907a.js.map