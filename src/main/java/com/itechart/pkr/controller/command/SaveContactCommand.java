package com.itechart.pkr.controller.command;


import com.itechart.pkr.controller.View;

import javax.servlet.http.HttpServletRequest;

public class SaveContactCommand implements ICommand {
// attachment.item
    //phone.item - name , а в его значении лежит JSON
    //


    @Override
    public View execute(HttpServletRequest request) {
//        ObjectMapper mapper = new ObjectMapper();
//        final AttachmentService attachService = ( AttachmentService )context.getAttribute( "attachmentservice" );
//        final PhoneService phoneService = ( PhoneService )context.getAttribute( "phoneservice" );
//
//        final ArrayList<Attachment> forDeleteAttachs = new ArrayList<Attachment>();
//        final ArrayList<Attachment> forInsertAttachs = new ArrayList<Attachment>();
//        final ArrayList<Attachment> forUpdateAttachs = new ArrayList<Attachment>();
//
//        final ArrayList<Phone> forDeletePhones = new ArrayList<Phone>();
//        final ArrayList<Phone> forInsertPhones = new ArrayList<Phone>();
//        final ArrayList<Phone> forUpdatePhones = new ArrayList<Phone>();
//
//
//        Contact contact = new Contact();
//        contact.setId( Integer.valueOf( parameter.getParameter( "contact.id" ) ) );
//
//        try {
//
//            final Enumeration<String> paramNames = parameter.getParametersNames();
////            List<Phone> phones = new ArrayList<>();
////            List<Attachment> attachments = new ArrayList<>();
//            String currentId, status;
//
//            while (paramNames.hasMoreElements()) {
//
//                String paramName = paramNames.nextElement();
//
//                if (paramName.contains("item")) {
//
//                    SaveContactCommand.InstanceInfo instanceInfo = mapper.readValue( parameter.getParameter( paramName ), SaveContactCommand.InstanceInfo.class );
//                    String typeOfObject = paramName.split( "\\." )[ 0 ];
//                    Phone tempPhone = null;
//                    Attachment tempAttachemnt = null;
//                    Class clazz = null;
//                    switch (typeOfObject) {
//                        case "Phone":
//
//                            tempPhone = new Phone();
//                            tempPhone.setId( Integer.valueOf( instanceInfo.id ) );
//                            clazz = tempPhone.getClass();
//                            break;
//
//                        case "Attachment":
//
//                            tempAttachemnt = new Attachment();
//                            tempAttachemnt.setId( Integer.valueOf( instanceInfo.id ) );
//                            clazz = tempAttachemnt.getClass();
//                            break;
//
//                    }
//
//                    //Нужно десериализовать value этого параметра( JSON ) V
//
//                    //там будет филд status и id(если что смотреть метод submit javascript-а)
//
//                    //Из paramName достать строку,которая содержится до точки - это тип объекта
//
//                    //String typeOfObject = paramName.split( "." )[ 0 ];
//                    //InnerClass obj = JSON.parse( request.getParameter( paramName ) );
//
//                    //Создать объект целевого типа( attach or phone )
//
//                    if ( instanceInfo.status != "deleted" ) {
//                        Enumeration<String> paramNames1 = parameter.getParametersNames();
//                        while (paramNames1.hasMoreElements()) {
//
//                            String currentinputName = paramNames.nextElement();
//                            String[] parts = currentinputName.split("\\.");
//
//                            if (!currentinputName.contains("src") && (typeOfObject + "." + instanceInfo.id).equals(parts[0] + "." + parts[1])) {
//
//                                Field field = clazz.getField(parts[2]);
//                                if ("Attachment".equals(typeOfObject)) {
//
//                                    Reflection.setFieldValue(field, parameter.getParameter(currentinputName), tempAttachemnt);
//
//                                } else {
//
//                                    Reflection.setFieldValue(field, parameter.getParameter(currentinputName), tempPhone);
//
//                                }
//
//                            }
//
//                            //начинаем бежать по именам параметров заново
//                            //связь между полями - айдишка, которую надо достать из десеарилизованного объекта и тип объекта
//
//                            paramName = paramNames.nextElement();
//
//                            //String typeOfObject1 = paramName.split( "." )[ 0 ];
//                            //String id = paramName.split( "." )[ 1 ];
//
//                            //if ( typeOfObject == typeOfObject1 && id == obj.id )
//
//                            //СОБИРАЕШЬ ОБЪЕКТ
//
//                            //}
//
//
//                        }
//                    }
//
//                    if ( "Attachment".equals( typeOfObject ) ) {
//
//                        if ( instanceInfo.status == "deleted" ) {
//
//                            forDeleteAttachs.add( tempAttachemnt );
//
//                        } else if ( instanceInfo.status == "modified" ) {
//
//                            forUpdateAttachs.add( tempAttachemnt );
//
//                        } else {
//
//                            forInsertAttachs.add( tempAttachemnt );
//
//                        }
//
//                    } else {
//
//                        if ( instanceInfo.status == "deleted" ) {
//
//                            forDeletePhones.add( tempPhone );
//
//                        } else if ( instanceInfo.status == "modified" ) {
//
//                            forUpdatePhones.add( tempPhone );
//
//                        } else {
//
//                            forInsertPhones.add(tempPhone);
//
//                        }
//
//                    }
//
//                    //}
//
//                    //if ( obj.status == 'new' ) {
//
//                    //insert
//
//                    //} else if ( obj.status == 'modified' ) {
//
//                    //update
//
//                    //} else {
//
//                    //delete
//
//                    //}
//
//                }
//
//            }
//
//            attachService.deleteAttachment( forDeleteAttachs );
//            attachService.updateAllAttachments( forUpdateAttachs );
//            attachService.addAllAttachments( forInsertAttachs, contact );
//
//            phoneService.deletePhone( forDeletePhones );
//            phoneService.updateAllPhones( forUpdatePhones );
//            phoneService.addAllPhones( forInsertPhones, contact );
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//
//        return new View("contacts");
//
//    }
//
//    private static class InstanceInfo {
//
//        public String status;
//        public String id;
//

        return new View("example");
   }

}
