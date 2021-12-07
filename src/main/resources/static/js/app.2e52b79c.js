(function (e) {
    function t(t) {
        for (var r, a, u = t[0], i = t[1], l = t[2], s = 0, d = []; s < u.length; s++) a = u[s], Object.prototype.hasOwnProperty.call(o, a) && o[a] && d.push(o[a][0]), o[a] = 0;
        for (r in i) Object.prototype.hasOwnProperty.call(i, r) && (e[r] = i[r]);
        f && f(t);
        while (d.length) d.shift()();
        return c.push.apply(c, l || []), n()
    }

    function n() {
        for (var e, t = 0; t < c.length; t++) {
            for (var n = c[t], r = !0, a = 1; a < n.length; a++) {
                var u = n[a];
                0 !== o[u] && (r = !1)
            }
            r && (c.splice(t--, 1), e = i(i.s = n[0]))
        }
        return e
    }

    var r = {}, a = {app: 0}, o = {app: 0}, c = [];

    function u(e) {
        return i.p + "js/" + ({}[e] || e) + "." + {
            "chunk-450f4192": "578aed19",
            "chunk-3003e869": "29e7600c",
            "chunk-46a8dabe": "8a145712",
            "chunk-6854aaa4": "c1da90d2",
            "chunk-95be1d1e": "f0c5a0b1",
            "chunk-b6d9c362": "7bd6bd6f",
            "chunk-da782798": "f7b654f5",
            "chunk-f266906a": "a2946d7f"
        }[e] + ".js"
    }

    function i(t) {
        if (r[t]) return r[t].exports;
        var n = r[t] = {i: t, l: !1, exports: {}};
        return e[t].call(n.exports, n, n.exports, i), n.l = !0, n.exports
    }

    i.e = function (e) {
        var t = [], n = {
            "chunk-3003e869": 1,
            "chunk-46a8dabe": 1,
            "chunk-6854aaa4": 1,
            "chunk-95be1d1e": 1,
            "chunk-b6d9c362": 1,
            "chunk-da782798": 1,
            "chunk-f266906a": 1
        };
        a[e] ? t.push(a[e]) : 0 !== a[e] && n[e] && t.push(a[e] = new Promise((function (t, n) {
            for (var r = "css/" + ({}[e] || e) + "." + {
                "chunk-450f4192": "31d6cfe0",
                "chunk-3003e869": "309edb69",
                "chunk-46a8dabe": "ee4ec105",
                "chunk-6854aaa4": "30079ddc",
                "chunk-95be1d1e": "e5888458",
                "chunk-b6d9c362": "5bd3bf7e",
                "chunk-da782798": "6915bbd2",
                "chunk-f266906a": "b9183f1a"
            }[e] + ".css", o = i.p + r, c = document.getElementsByTagName("link"), u = 0; u < c.length; u++) {
                var l = c[u], s = l.getAttribute("data-href") || l.getAttribute("href");
                if ("stylesheet" === l.rel && (s === r || s === o)) return t()
            }
            var d = document.getElementsByTagName("style");
            for (u = 0; u < d.length; u++) {
                l = d[u], s = l.getAttribute("data-href");
                if (s === r || s === o) return t()
            }
            var f = document.createElement("link");
            f.rel = "stylesheet", f.type = "text/css", f.onload = t, f.onerror = function (t) {
                var r = t && t.target && t.target.src || o,
                    c = new Error("Loading CSS chunk " + e + " failed.\n(" + r + ")");
                c.code = "CSS_CHUNK_LOAD_FAILED", c.request = r, delete a[e], f.parentNode.removeChild(f), n(c)
            }, f.href = o;
            var h = document.getElementsByTagName("head")[0];
            h.appendChild(f)
        })).then((function () {
            a[e] = 0
        })));
        var r = o[e];
        if (0 !== r) if (r) t.push(r[2]); else {
            var c = new Promise((function (t, n) {
                r = o[e] = [t, n]
            }));
            t.push(r[2] = c);
            var l, s = document.createElement("script");
            s.charset = "utf-8", s.timeout = 120, i.nc && s.setAttribute("nonce", i.nc), s.src = u(e);
            var d = new Error;
            l = function (t) {
                s.onerror = s.onload = null, clearTimeout(f);
                var n = o[e];
                if (0 !== n) {
                    if (n) {
                        var r = t && ("load" === t.type ? "missing" : t.type), a = t && t.target && t.target.src;
                        d.message = "Loading chunk " + e + " failed.\n(" + r + ": " + a + ")", d.name = "ChunkLoadError", d.type = r, d.request = a, n[1](d)
                    }
                    o[e] = void 0
                }
            };
            var f = setTimeout((function () {
                l({type: "timeout", target: s})
            }), 12e4);
            s.onerror = s.onload = l, document.head.appendChild(s)
        }
        return Promise.all(t)
    }, i.m = e, i.c = r, i.d = function (e, t, n) {
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
        }), 2 & t && "string" != typeof e) for (var r in e) i.d(n, r, function (t) {
            return e[t]
        }.bind(null, r));
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
    }, "56d7": function (e, t, n) {
        "use strict";
        n.r(t);
        n("e260"), n("e6cf"), n("cca6"), n("a79d");
        var r = n("2b0e"), a = function () {
                var e = this, t = e.$createElement, n = e._self._c || t;
                return n("div", {attrs: {id: "app"}}, [n("router-view")], 1)
            }, o = [], c = {
                data: function () {
                    return {}
                }, methods: {}
            }, u = c, i = n("2877"), l = Object(i["a"])(u, a, o, !1, null, null, null), s = l.exports,
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
                }, [n("el-menu-item", {attrs: {index: "/home"}}, [e._v("首页")]), n("el-menu-item", {attrs: {index: "/practice"}}, [e._v("练习")]), n("el-menu-item", {attrs: {index: "/task"}}, [e._v("作业")])], 1), n("el-button", {on: {click: e.logout}}, [e._v("退出")])], 1), n("router-view")], 1)
            }, h = [], p = {
                data: function () {
                    return {activeIndex: this.$route.path}
                }, created: function () {
                }, methods: {
                    logout: function () {
                        this.$store.commit("setClassId", null), localStorage.removeItem("hmhz-intergral-token"), localStorage.removeItem("classId"), this.$router.push("/login")
                    }
                }
            }, m = p, b = (n("e8af"), Object(i["a"])(m, f, h, !1, null, "f9afdbc6", null)), v = b.exports;
        r["default"].use(d["a"]);
        var k = [{path: "/", redirect: "/login"}, {
            path: "/home",
            component: v,
            children: [{
                path: "", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-95be1d1e")]).then(n.bind(null, "bb51"))
                }
            }, {
                path: "/practice", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-3003e869")]).then(n.bind(null, "6e16"))
                }
            }, {
                path: "/task", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-da782798")]).then(n.bind(null, "2434"))
                }
            }]
        }, {
            path: "/login", component: function () {
                return Promise.all([n.e("chunk-450f4192"), n.e("chunk-6854aaa4")]).then(n.bind(null, "d9c9"))
            }
        }, {
            path: "/students/home", component: function () {
                return Promise.all([n.e("chunk-450f4192"), n.e("chunk-46a8dabe")]).then(n.bind(null, "c3c1"))
            }, redirect: "/students/practiceList", children: [{
                path: "/students/practiceList", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-b6d9c362")]).then(n.bind(null, "38f2"))
                }
            }, {
                path: "/students/taskList", component: function () {
                    return Promise.all([n.e("chunk-450f4192"), n.e("chunk-f266906a")]).then(n.bind(null, "ee4c"))
                }
            }]
        }], g = new d["a"]({routes: k});
        g.beforeEach((function (e, t, n) {
            var r = localStorage.getItem("hmhz-intergral-token");
            if (r) n(); else {
                if ("/login" === e.path) return n();
                n("/login")
            }
        }));
        var y = g, w = n("2f62");
        r["default"].use(w["a"]);
        var _ = new w["a"].Store({
            state: {classId: localStorage.getItem("classId") || ""},
            mutations: {
                setClassId: function (e, t) {
                    e.classId = t, localStorage.setItem("classId", t)
                }
            },
            actions: {},
            modules: {}
        }), P = n("5c96"), x = n.n(P);
        n("0fae"), n("845fb"), n("acc7");
        r["default"].use(x.a), r["default"].config.productionTip = !1, new r["default"]({
            router: y,
            store: _,
            render: function (e) {
                return e(s)
            }
        }).$mount("#app")
    }, "6c80": function (e, t, n) {
    }, "845fb": function (e, t, n) {
    }, acc7: function (e, t, n) {
    }, e8af: function (e, t, n) {
        "use strict";
        n("6c80")
    }
});
//# sourceMappingURL=app.2e52b79c.js.map