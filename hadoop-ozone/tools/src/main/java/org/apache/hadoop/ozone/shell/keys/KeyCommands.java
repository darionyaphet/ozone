/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.hadoop.ozone.shell.keys;

import java.util.concurrent.Callable;

import org.apache.hadoop.hdds.cli.HddsVersionProvider;
import org.apache.hadoop.hdds.cli.MissingSubcommandException;
import org.apache.hadoop.ozone.shell.Shell;

import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

/**
 * Subcommand to group key related operations.
 */
@Command(name = "key",
    description = "Key specific operations",
    subcommands = {
        InfoKeyHandler.class,
        ListKeyHandler.class,
        GetKeyHandler.class,
        CatKeyHandler.class,
        PutKeyHandler.class,
        RenameKeyHandler.class,
        RewriteKeyHandler.class,
        CopyKeyHandler.class,
        DeleteKeyHandler.class,
        AddAclKeyHandler.class,
        RemoveAclKeyHandler.class,
        SetAclKeyHandler.class,
        GetAclKeyHandler.class,
        ChecksumKeyHandler.class
    },
    mixinStandardHelpOptions = true,
    versionProvider = HddsVersionProvider.class)
public class KeyCommands implements Callable<Void> {

  @ParentCommand
  private Shell shell;

  @Override
  public Void call() throws Exception {
    throw new MissingSubcommandException(
        this.shell.getCmd().getSubcommands().get("key"));
  }
}
