/*

 * Copyright (c) Microsoft Corporation. All rights reserved.

 * Licensed under the MIT License. See LICENSE in the project root for

 * license information.

 */
package org.jenkinsci.plugins.serviceFabric;

import hudson.model.AbstractBuild;
import hudson.model.Action;

/**
 * Created by prit8976 on 8/27/15.
 */
public class ServiceFabricBuildAction implements Action {

    private String command;
    private AbstractBuild<?, ?> build;

    @Override
    public String getIconFileName() {
        return "/plugin/serviceFabric/img/build-goals.png";
    }

    @Override
    public String getDisplayName() {
        return "Service Fabric Deployment";
    }

    @Override
    public String getUrlName() {
        return "serviceFabricBA";
    }

    public String getCommand() {
        return this.command;
    }

    public int getBuildNumber() {
        return this.build.number;
    }

    public AbstractBuild<?, ?> getBuild() {
        return build;
    }

    ServiceFabricBuildAction(final String command, final AbstractBuild<?, ?> build)
    {
        this.command = command;
        this.build = build;
    }
}
