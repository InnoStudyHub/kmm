@file:OptIn(ExperimentalPagerApi::class)

package com.seytkalievm.studyhub.android.presentation.session

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.seytkalievm.studyhub.android.presentation.session.for_you.ForYouPage
import com.seytkalievm.studyhub.android.presentation.session.recent.RecentPage
import com.seytkalievm.studyhub.android.presentation.util.TabItem
import kotlinx.coroutines.launch


@Preview
@Composable
fun HomeScreen(){
    val tabs = listOf(
        TabItem("For you", null) { ForYouPage() },
        TabItem("Recent", null) { RecentPage() }
    )

    val pagerState = rememberPagerState(initialPage = 0,)
    
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Home", fontSize = 18.sp) }) }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}


@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState){
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = {tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed { index, tabItem ->
            LeadingIconTab(
                icon = {},
                selected = pagerState.currentPage == index,
                text = { 
                    Text(text = tabItem.title)
                },
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState){
    HorizontalPager(state = pagerState, count = tabs.size) {page ->
        tabs[page].screen()
    }
}