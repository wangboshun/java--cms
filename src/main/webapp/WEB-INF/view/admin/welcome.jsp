<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>管理后台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="renderer" content="webkit" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="format-detection" content="telephone=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="/resources/lib/jqmodules/css/font/iconfont.css" media="all" charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="/resources/lib/layui/css/layui.css" media="all" charset="UTF-8" />
    <link rel="stylesheet" type="text/css" href="/resources/lib/jqmodules/css/main.css" media="all" charset="UTF-8" />
</head>
<body>
<div class="layui-fluid larry-wrapper">
    <div class="layui-row layui-col-space30">
        <div class="layui-col-xs6 layui-col-sm4 layui-col-md2">
            <section class="panel">
                <div class="symbol bgcolor-blue">
                    <i class="iconfont"></i>
                </div>
                <div class="value tab-menu">
                    <a href="http://www.qq.com" data-title="用户总量"> <i class="iconfont " data-icon=""></i> <h1>10</h1> </a>
                    <a href="http://www.qq.com" data-parent="true" data-title="用户总量"> <i class="iconfont " data-icon=""></i><span>用户总量</span></a>
                </div>
            </section>
        </div>
        <div class="layui-col-xs6 layui-col-sm4 layui-col-md2">
            <section class="panel">
                <div class="symbol bgcolor-commred">
                    <i class="iconfont"></i>
                </div>
                <div class="value tab-menu">
                    <a href="http://www.qq.com" data-title="今日注册"> <i class="iconfont " data-icon=""></i> <h1>10</h1> </a>
                    <a href="http://www.qq.com" data-title="今日注册"> <i class="iconfont " data-icon=""></i><span>今日注册</span></a>
                </div>
            </section>
        </div>
        <div class="layui-col-xs6 layui-col-sm4 layui-col-md2">
            <section class="panel">
                <div class="symbol bgcolor-dark-green">
                    <i class="iconfont"></i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="文章总数"> <i class="iconfont " data-icon=""></i> <h1>10</h1> </a>
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="文章总数"> <i class="iconfont " data-icon=""></i><span>文章总数</span></a>
                </div>
            </section>
        </div>
        <div class="layui-col-xs6 layui-col-sm4 layui-col-md2">
            <section class="panel">
                <div class="symbol bgcolor-yellow-green">
                    <i class="iconfont"></i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="今日新增"> <i class="iconfont " data-icon=""></i> <h1>10</h1> </a>
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="今日新增"> <i class="iconfont " data-icon=""></i><span>今日新增</span></a>
                </div>
            </section>
        </div>
        <div class="layui-col-xs6 layui-col-sm4 layui-col-md2">
            <section class="panel">
                <div class="symbol bgcolor-orange">
                    <i class="iconfont"></i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="评论总数"> <i class="iconfont " data-icon=""></i> <h1>10</h1> </a>
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="评论总数"> <i class="iconfont " data-icon=""></i><span>评论总数</span></a>
                </div>
            </section>
        </div>
        <div class="layui-col-xs6 layui-col-sm4 layui-col-md2">
            <section class="panel">
                <div class="symbol bgcolor-yellow">
                    <i class="iconfont"></i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="今日评论"> <i class="iconfont " data-icon=""></i> <h1>10</h1> </a>
                    <a href="javascript:;" data-url="user-info.html" data-parent="true" data-title="今日评论"> <i class="iconfont " data-icon=""></i><span>今日评论</span></a>
                </div>
            </section>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-xs12">
            <blockquote class="layui-elem-quote">
                鉴于好群兄弟的需求，在2.0的基础上分支出一个精简版本，该版本只保留了模板框架所需的基本js，并更新到了layui2.1.7版，表格用的得layui的原生表格，数据也由表格内置的方法获取,用不习惯现有的2.0版本或者觉得不用好的兄弟，可以下载simple版试下，没有太多的东西，只界面的与菜单的纯html模板。不要问我表格为什么这么丑，我也回答不了..哇咔咔，另外，请把文件放到服务器环境中使用，因为表格数据都是ajax获取的
            </blockquote>
        </div>
    </div>
    <div class="layui-row layui-col-space10">
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md6">
            <section class="panel log">
                <div class="panel-heading">
                    更新日志
                    <a href="javascript:;" class="pull-right panel-toggle"><i class="iconfont"></i></a>
                </div>
                <div class="panel-body">
                    <h2>jQadmin后台模板v2.0.1-simple 2017-11-12</h2>
                    <ul>
                        <li>更新layui到2.2.0版</li>
                    </ul>
                    <h2>jQadmin后台模板v2.0.0-simple 2017-11-12</h2>
                    <ul>
                        <li> 精简代码，去除所有异步提交的js，保留模板最基本的js</li>
                        <li> 增加两个主题</li>
                        <li> 优化了菜单</li>
                    </ul>
                    <h2>jQadmin后台模板v2.0.0 2017-07-29</h2>
                    <ul>
                        <li> 重构代码，修复一些BUG</li>
                        <li> 使用json数据模拟真实操作</li>
                        <li> 页面更简化</li>
                        <li> 支持客户端或服务端分页</li>
                        <li> 加入省市区联动选择</li>
                        <li> 更新权限选择模块</li>
                        <li> 添加了一些钩子函数</li>
                        <li> 更新的太多，不记得了，自己体验吧</li>
                    </ul>
                    <h2>jQadmin后台模板v1.3.4r2 2017-05-09</h2>
                    <ul>
                        <li> 修复弹窗过高，挣出屏幕BUG</li>
                    </ul>
                    <h2>jQadmin后台模板v1.3.4r1 2017-05-08</h2>
                    <ul>
                        <li> 修复火狐刷新打开菜单列表出错BUG</li>
                    </ul>
                    <p>更多帮助文档请移步到 <a href="http://www.kancloud.cn/jqcool/jqadmin" target="_blank" class="layui-btn layui-btn-sm">使用手册</a></p>
                </div>
            </section>
        </div>
        <div class="layui-col-xs12 layui-col-sm12 layui-col-md6">
            <section class="panel">
                <div class="panel-heading">
                    网站信息
                    <a href="javascript:;" class="pull-right panel-toggle"><i class="iconfont"></i></a>
                </div>
                <div class="panel-body">
                    <table class="layui-table">
                        <tbody>
                        <tr>
                            <td> <strong>软件名称</strong>： </td>
                            <td> <a href="http://jqadmin.jqcool.net">jqadmin后台模板</a> </td>
                        </tr>
                        <tr>
                            <td> <strong>软件版本</strong>： </td>
                            <td> V2.0.0 </td>
                        </tr>
                        <tr>
                            <td> <strong>开发作者</strong>： </td>
                            <td>Paco</td>
                        </tr>
                        <tr>
                            <td> <strong>使用手册</strong>： </td>
                            <td> <a class="layui-btn  layui-btn-sm  layui-btn-primary" href="http://www.kancloud.cn/jqcool/jqadmin" target="_blank">使用手册1.3.4</a> </td>
                        </tr>
                        <tr>
                            <td> <strong>模板下载</strong>： </td>
                            <td><a href="https://git.oschina.net/jqcool/jqadmin" target="_blank" class="layui-btn layui-btn-primary layui-btn-sm">码云下载</a> <a href="https://jqadmin.jqcool.net/jqadmin-2.0.0.zip" target="_blank" class="layui-btn layui-btn-primary layui-btn-sm">2.0.0版</a> <a href="https://jqadmin.jqcool.net/jqadmin-2.0.0-simple.zip" target="_blank" class="layui-btn layui-btn-primary layui-btn-sm">2.0.1-simple版</a> </td>
                        </tr>
                        <tr>
                            <td> <strong>QQ讨论群</strong>： </td>
                            <td> <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=bb0dbfcf87d269f825807a1ba7ff6a1c09d07b98b724192ed325e840284b4821"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="jQ酷" title="jQ酷" /></a> 入群答案：jqadmin </td>
                        </tr>
                        <tr>
                            <td> <strong>服务器环境</strong>： </td>
                            <td>windows</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </section>
            <section class="panel">
                <div class="panel-heading">
                    数据统计
                    <a href="javascript:;" class="pull-right panel-toggle"><i class="iconfont"></i></a>
                </div>
            </section>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/lib/layui/layui.js" charset="UTF-8"></script>
<script type="text/javascript" src="/resources/lib/jqmodules/version.js" charset="UTF-8"></script>
<script type="text/javascript" src="/resources/lib/jqmodules/common.js" charset="UTF-8"></script>
</body>
</html>