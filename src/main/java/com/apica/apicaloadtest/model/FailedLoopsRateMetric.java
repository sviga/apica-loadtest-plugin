/*
 * The MIT License
 *
 * Copyright 2015 andras.nemes.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.apica.apicaloadtest.model;

import com.apica.apicaloadtest.jobexecution.PerformanceSummary;

/**
 *
 * @author andras.nemes
 */
public class FailedLoopsRateMetric extends LoadtestThresholdMetric
{

    public FailedLoopsRateMetric()
    {
        super("failed_loops", "Failed loops rate (%)", "%");
    }

    @Override
    public double extractActualValueFrom(PerformanceSummary performanceSummary)
    {
        int passedLoops = performanceSummary.getTotalPassedLoops();
        int failedLoops = performanceSummary.getTotalFailedLoops();
        int totalLoops = passedLoops + failedLoops;
        double failedLoopsShare = (double) (failedLoops * 100.0) / (double) (totalLoops * 100.0);
        return failedLoopsShare;
    }

}
