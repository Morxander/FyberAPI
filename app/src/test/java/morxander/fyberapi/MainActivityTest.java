package morxander.fyberapi;

import android.content.Intent;
import android.widget.EditText;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import morxander.fyberapi.activities.MainActivity;
import morxander.fyberapi.activities.OffersActivity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by morxander on 10/2/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    @Test
    public void testingFillingData() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.button_fill_data).performClick();

        EditText editTextUid = (EditText) activity.findViewById(R.id.edittext_uid);
        assertThat(editTextUid.getText().toString()).isEqualTo("spiderman");

        EditText editTextApiKey = (EditText) activity.findViewById(R.id.edittext_api_key);
        assertThat(editTextApiKey.getText().toString()).isEqualTo("1c915e3b5d42d05136185030892fbb846c278927");

        EditText editTextAppId = (EditText) activity.findViewById(R.id.edittext_app_id);
        assertThat(editTextAppId.getText().toString()).isEqualTo("2070");

        EditText editTextPub = (EditText) activity.findViewById(R.id.edittext_pub);
        assertThat(editTextPub.getText().toString()).isEqualTo("campaign2");
    }

    @Test
    public void testingGoingToNextActivity() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.button_fill_data).performClick();
        activity.findViewById(R.id.button_submit).performClick();

        Intent expectedIntent = new Intent(activity, OffersActivity.class);

        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();

        Assert.assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
