package com.github.mdssjc.processor;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

@SupportedAnnotationTypes("com.github.mdssjc.processor.Immutable")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class GeneratingAnnotationProcessor extends AbstractProcessor {

  @Override
  public boolean process(final Set<? extends TypeElement> annotations,
      final RoundEnvironment roundEnv) {

    for (final Element element : roundEnv
      .getElementsAnnotatedWith(Immutable.class)) {
      if (element instanceof TypeElement) {
        final TypeElement typeElement = (TypeElement) element;
        final PackageElement packageElement = (PackageElement) typeElement
          .getEnclosingElement();

        try {
          final String className = typeElement.getSimpleName() + "Immutable";
          final JavaFileObject fileObject = this.processingEnv.getFiler()
            .createSourceFile(
                packageElement.getQualifiedName() + "." + className);

          try (Writer writter = fileObject.openWriter()) {
            writter
              .append("package " + packageElement.getQualifiedName() + ";");
            writter.append("\\n\\n");
            writter.append("public class " + className + " {");
            writter.append("\\n");
            writter.append("}");
          }
        } catch (final IOException ex) {
          this.processingEnv.getMessager()
            .printMessage(Kind.ERROR, ex.getMessage());
        }
      }
    }

    // Claiming that annotations have been processed by this processor
    return true;
  }
}
