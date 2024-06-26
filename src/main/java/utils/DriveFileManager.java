package utils;// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

// [START drive_quickstart]

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import static com.google.auth.oauth2.GoogleCredentials.fromStream;

/* class to demonstrate use of Drive files list API */
public class DriveFileManager {
  /**
   * Application name.
   */
  private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
  /**
   * Global instance of the JSON factory.
   */
  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
  /**
   * Directory to store authorization tokens for this application.
   */
  private static final String TOKENS_DIRECTORY_PATH = "tokens";

  /**
   * Global instance of the scopes required by this quickstart.
   * If modifying these scopes, delete your previously saved tokens/ folder.
   */
  private static final List<String> SCOPES =
      Collections.singletonList(DriveScopes.DRIVE_METADATA_READONLY);
  private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

  /**
   * Creates an authorized Credential object.
   *
   * @param HTTP_TRANSPORT The network HTTP Transport.
   * @return An authorized Credential object.
   * @throws IOException If the credentials.json file cannot be found.
   */
  private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
      throws IOException {
    // Load client secrets.
    InputStream in = DriveFileManager.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
    if (in == null) {
      throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
    }
    GoogleClientSecrets clientSecrets =
        GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

    // Build flow and trigger user authorization request.
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
        .setAccessType("offline")
        .build();
    LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
    Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    //returns an authorized Credential object.
    return credential;
  }

  public static void conectionDriveTest() throws IOException, GeneralSecurityException {
    // Build a new authorized API client service.
    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
        .setApplicationName(APPLICATION_NAME)
        .build();

    // Print the names and IDs for up to 10 files.
    FileList result = service.files().list()
        .setPageSize(10)
        .setFields("nextPageToken, files(id, name)")
        .execute();
    List<File> files = result.getFiles();
    if (files == null || files.isEmpty()) {
      System.out.println("No files found.");
    } else {
      System.out.println("Files:");
      for (File file : files) {
        System.out.printf("%s (%s)\n", file.getName(), file.getId());
      }
    }
  }

  public static String uploadBasic(String data) throws IOException, GeneralSecurityException {
    // Load pre-authorized user credentials from the environment.
    // TODO(developer) - See https://developers.google.com/identity for
    // guides on implementing OAuth2 for your application.
    GoogleCredentials credentials = fromStream(Files.newInputStream(Paths.get("src/main/resources/mobile-automation.json")));

            /*GoogleCredentials.getApplicationDefault()
            .createScoped(Arrays.asList(DriveScopes.DRIVE_FILE));

             */

    HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(
            credentials);

    // Build a new authorized API client service.
    Drive service = new Drive.Builder(new NetHttpTransport(),
            GsonFactory.getDefaultInstance(),
            requestInitializer)
            .setApplicationName("Drive samples")
            .build();
    // Upload file photo.jpg on drive.
    File fileMetadata = new File();
    fileMetadata.setName("photo.jpg");
    // File's content.
    java.io.File filePath = new java.io.File("files/photo.jpg");
    // Specify media type and file-path for file.
    FileContent mediaContent = new FileContent("image/jpeg", filePath);
    try {
      File file = service.files().create(fileMetadata, mediaContent)
              .setFields("id")
              .execute();
      System.out.println("File ID: " + file.getId());
      return file.getId();
    } catch (GoogleJsonResponseException e) {
      // TODO(developer) - handle error appropriately
      System.err.println("Unable to upload file: " + e.getDetails());
      throw e;
    }
  }
}
// [END drive_quickstart]
