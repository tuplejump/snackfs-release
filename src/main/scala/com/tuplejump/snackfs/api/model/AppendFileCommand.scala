/*
 * Licensed to Tuplejump Software Pvt. Ltd. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Tuplejump Software Pvt. Ltd. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.tuplejump.snackfs.api.model

import scala.concurrent.duration.FiniteDuration
import java.io.IOException
import org.apache.hadoop.fs.{FSDataOutputStream, Path}
import org.apache.hadoop.util.Progressable
import com.twitter.logging.Logger
import com.tuplejump.snackfs.cassandra.partial.FileSystemStore
import com.tuplejump.snackfs.api.partial.Command

object AppendFileCommand extends Command {
  private lazy val log = Logger.get(getClass)

  def apply(store: FileSystemStore,
            filePath: Path,
            bufferSize: Int,
            progress: Progressable,
            atMost: FiniteDuration): FSDataOutputStream = {

    val ex = new IOException("Appending to existing file is not supported.")
    log.error(ex, "Failed to append to file %s as it is not supported", filePath)
    throw ex
  }
}
