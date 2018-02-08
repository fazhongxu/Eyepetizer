package cn.edu.ncist.eyepetizer.bean

/**
 * Created by xxl on 2017/7/24.
 */

data class HomeBean(
		val issueList: List<Issue>,
		val nextPageUrl: String, //http://baobab.kaiyanapp.com/api/v2/feed?date=1515891600000&num=2
		val nextPublishTime: Long, //1516150800000
		val newestIssueType: String, //morning
		val dialog: Any //null
)

data class Issue(
		val releaseTime: Long, //1516064400000
		val type: String, //morning
		val date: Long, //1516064400000
		val publishTime: Long, //1516064400000
		val itemList: List<Item>,
		val count: Int //7
)

data class Item(
		val type: String, //banner2
		val data: Data,
		val tag: Any, //null
		val id: Int, //0
		val adIndex: Int //-1
)

data class Data(
		val dataType: String, //Banner
		val id: Int, //0
		val title: String,
		val description: String,
		val image: String, //http://img.kaiyanapp.com/eef24aa10ab6cf17b5a512943ec22053.jpeg?imageMogr2/quality/60/format/jpg
		val actionUrl: String,
		val adTrack: Any, //null
		val shade: Boolean, //false
		val label: Any, //null
		val labelList: Any, //null
		val header: Any //null
)