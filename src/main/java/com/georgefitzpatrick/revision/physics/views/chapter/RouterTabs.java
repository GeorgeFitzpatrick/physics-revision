package com.georgefitzpatrick.revision.physics.views.chapter;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class RouterTabs extends Tabs implements BeforeEnterObserver {

    private final Map<RouterLink, Tab> routerLinkToTab;

    public RouterTabs() {
        routerLinkToTab = new HashMap<>();
    }

    public void add(@NotNull RouterLink link) {
        link.setHighlightCondition(HighlightConditions.sameLocation());
        link.setHighlightAction((l, b) -> {
            if (b)
                setSelectedTab(routerLinkToTab.get(link));
        });

        var tab = new Tab(link);
        routerLinkToTab.put(link, tab);
        add(tab);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        setSelectedTab(null);
    }

}
