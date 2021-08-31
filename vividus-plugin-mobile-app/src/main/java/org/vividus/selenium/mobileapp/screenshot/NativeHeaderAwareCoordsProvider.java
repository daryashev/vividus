/*
 * Copyright 2019-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vividus.selenium.mobileapp.screenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.vividus.selenium.mobileapp.MobileAppWebDriverManager;
import org.vividus.selenium.screenshot.AbstractAdjustingCoordsProvider;
import org.vividus.ui.context.IUiContext;

import ru.yandex.qatools.ashot.coordinates.Coords;

public class NativeHeaderAwareCoordsProvider extends AbstractAdjustingCoordsProvider
{
    private static final long serialVersionUID = 2966521618709606533L;

    private final transient MobileAppWebDriverManager mobileAppWebDriverManager;

    public NativeHeaderAwareCoordsProvider(MobileAppWebDriverManager mobileAppWebDriverManager, IUiContext uiContext)
    {
        super(uiContext);
        this.mobileAppWebDriverManager = mobileAppWebDriverManager;
    }

    @Override
    public Coords ofElement(WebDriver driver, WebElement element)
    {
        Coords coords = getCoords(element);
        return getUiContext().getSearchContext() == element ? coords : adjustToSearchContext(coords);
    }

    protected Coords getCoords(WebElement element)
    {
        Coords coords = super.ofElement(null, element);
        return new Coords(coords.x, coords.y - mobileAppWebDriverManager.getStatusBarSize(), coords.width,
                coords.height);
    }
}
