package org.jetbrains.jps.incremental;

import org.jetbrains.jps.ModuleChunk;

import java.io.File;

/**
 * Use {@link BuilderService} to register implementations of this class
 *
 * @author Eugene Zhuravlev
 *         Date: 9/17/11
 */
public abstract class ModuleLevelBuilder extends Builder {
  private final BuilderCategory myCategory;

  protected ModuleLevelBuilder(BuilderCategory category) {
    myCategory = category;
  }

  public enum ExitCode {
    NOTHING_DONE, OK, ABORT, ADDITIONAL_PASS_REQUIRED, CHUNK_REBUILD_REQUIRED
  }

  public abstract ExitCode build(CompileContext context, ModuleChunk chunk) throws ProjectBuildException;

  public boolean shouldHonorFileEncodingForCompilation(File file) {
    return false;
  }

  public final BuilderCategory getCategory() {
    return myCategory;
  }

  public void cleanupResources(CompileContext context, ModuleChunk chunk) {
  }
}
