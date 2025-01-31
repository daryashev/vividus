/*
 * Copyright 2019-2022 the original author or authors.
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

package org.vividus.selenium.screenshot.strategies;

import org.openqa.selenium.WebDriver;

import pazone.ashot.cutter.FixedCutStrategy;

public class StickyHeaderCutStrategy extends FixedCutStrategy
{
    private static final long serialVersionUID = 8998114998032916911L;

    private boolean firstCut = true;

    public StickyHeaderCutStrategy(int headerToCut, int footerToCut)
    {
        super(headerToCut, footerToCut);
    }

    @Override
    public int getHeaderHeight(WebDriver driver)
    {
        if (firstCut)
        {
            firstCut = false;
            return 0;
        }
        return super.getHeaderHeight(driver);
    }
}
