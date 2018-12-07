/*package Annotation;

import java.io.PrintStream;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"Persistent", "Id", "Property"})
public class HibernateAnnotationProcessor extends AbstractProcessor{
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv){
		PrintStream ps = null;
		try{
			for(Element t : roundEnv.getElementsAnnotatedWith(Persistent.class)){
				Name clazzName = t.getAnnotation(Persistent.class);
				ps = new PrintStream(new FileOutputStream(calzzName + ".hbm.xml"));
				ps.println("<?xml version=\"1.0\"?>");
				ps.println("<!DOCTYPE hibernate-mapping PUBLIC");
				ps.println("	\"-//Hibernate/Hibernate " + "Mapping DTD 3.0//EN\"");
				ps.println("	\" http://www.hibernate.org/dtd/" + "hibernate-mapping-3.0.dtd\">");
				ps.println("hibernate-mapping>");
				ps.print("	<class name=\"" + per.table() + "\">");
				for(Elenent f : t.getEnclosedElements()){
					if(f.getKind() == ElementKind.FIELD){
						Id id = f.getAnnotation(Id.class;
						if(id != null){
							ps.println("	<id name=\""
									+ f.getSimpleName()
									+ "\" column=\"" + id.column()
									+ "\"" type=\"" + id.type()
									+ "\">");
							ps.println("	<generator class=\""
									+ id.generator() + "\"/>");
							ps.println("	</id>");
						}
						Propetry p = f.getAnnotation(Property.class;
						if(p != null){
							ps.println("	<property name=\""
									+f.getSimpleName()
									+ "\" column=\"" + p.column()
									+ "\" type=\"" + p.type()
									+ "\">");
						}
					}
				}
				ps.println("	</class>");
				ps.println("</hibernate-mapping>");
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
			if (ps != null){
				try{
					ps.close();
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		return true;
	}
}

	
	*/
	
	
	
	
	
	