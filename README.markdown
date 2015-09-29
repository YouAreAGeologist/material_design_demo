# Topeka for Android

A fun to play quiz that showcases material design on Android

### Introduction

Material design is a new system for visual, interaction and motion design. We
originally launched the [Topeka web app](https://github.com/Polymer/topeka)
as an Open Source example of material design on the web.

The Android version of Topeka demonstrates that the same branding and material
design principles can be used to create a consistent experience across
platforms. You can read more about it on the
[Android Developers
blog](http://android-developers.blogspot.co.uk/2015/06/more-material-design-with-topeka-for_16.html).

### Screenshots

<img src="screenshots/categories.png" width="30%" />
<img src="screenshots/category_history.png" width="30%" />
<img src="screenshots/quiz_shakespeare.png" width="30%" />

### Getting Started

Clone this repository, enter the top level directory and run <code>./gradlew tasks</code> to get an overview of all the tasks available for this project.

Some important tasks are:

```
assembleDebug - Assembles all Debug builds.
installDebug - Installs the Debug build.
connectedAndroidTest - Installs and runs the tests for Debug build on connected
devices.
test - Run all unit tests.
```

### Support

- Google+ Community: https://plus.google.com/communities/105153134372062985968

- Stack Overflow: http://stackoverflow.com/questions/tagged/android

If you've found an error in this sample, please file an issue:

https://github.com/googlesamples/android-topeka/issues

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request through GitHub.

### License


```
Copyright 2015 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```

# activity  - 撰寫登入、問題庫、測驗遊戲三大主體的動作
## SignInActivity - 登入介面行為
### method
  - public static void start(Activity activity, Boolean edit, ActivityOptions options)
  - protected void onCreate(Bundle savedInstanceState)
  - protected void onStop()
  - private boolean isInEditMode()
## CategorySelectionActivity - 題庫
### method
  - public static void start(Context context, Player player, ActivityOptions options)
  - public static void start(Context context, Player player)
  - protected void onCreate(Bundle savedInstanceState)
  - onResume()
  - protected void setUpToolbar(Player player)
  - public boolean onCreateOptionsMenu(Menu menu)
  - public boolean onOptionsItemSelected(MenuItem item)
  - private void signOut()
  - private String getDisplayName(Player player)
  - private void attachCategoryGridFragment()
  - private void setProgressBarVisibility(int visibility)
## QuizActivity - 測驗遊戲
### method
  - private View.OnClickListener mOnClickListener = new View.OnClickListener()
  - public static Intent getStartIntent(Context context, Category category)
  - protected void onCreate(Bundle savedInstanceState)
  - protected void onResume()
  - public void onSaveInstanceState
  - public void onBackPressed()
  - private void startQuizFromClickOn(final View view)
  - private void initQuizFragment()
  - public void proceed()
  - private void submitAnswer()
  - private void populate(String categoryId)
  - private void initLayout(String categoryId)
  - private void initToolbar(Category category)
# adapter - 將資料或圖片填入UI，共有6個Adapter
## AvatarAdapter - 登入頭像
### method
  - public AvatarAdapter(Context context)
  - public View getView(int position, View convertView, ViewGroup parent)
  - private void setAvatar(AvatarView mIcon, Avatar avatar)
  - public int getCount()
  - public Object getItem(int position)
  - public long getItemId(int position)
## CategoryAdapter - 題庫
### method
  - public CategoryAdapter(Activity activity)
  - public View getView(int position, View convertView, ViewGroup parent) 
  - public int getCount()
  - public Category getItem(int position)
  - public long getItemId(int position)
  - public boolean hasStableIds()
  - public boolean areAllItemsEnabled()
  - private void setCategoryIcon(Category category, ImageView icon)
  - public void notifyDataSetChanged()
  - private void updateCategories(Activity activity)
  - private LayerDrawable loadSolvedIcon(Category category, int categoryImageResource) 
  - private Drawable loadTintedCategoryDrawable(Category category, int categoryImageResource)
  - private void tintDrawable(Drawable drawable, @ColorRes int colorRes)
  - private int getColor(@ColorRes int colorRes)
## CategoryViewHolder
### method
  - public CategoryViewHolder(LinearLayout container)
## OptionsQuizAdapter - 進入測驗遊戲的初始畫面
### method
  - public OptionsQuizAdapter(String[] options, @LayoutRes int layoutId)
  - public OptionsQuizAdapter(String[] options, @LayoutRes int layoutId, Context context,
            boolean withPrefix)
  - public int getCount()
  - public String getItem(int position)
  - public long getItemId(int position)
  - public boolean hasStableIds()
  - public View getView(int position, View convertView, ViewGroup parent)
  - private String getText(int position)
  - private String getPrefix(int position)
## QuizAdapter - 測驗遊戲UI
### method
  - public QuizAdapter(Context context, Category category)
  - private int calculateViewTypeCount()
  - public int getCount()
  - public Quiz getItem(int position)
  - public long getItemId(int position)
  - public int getViewTypeCount()
  - public int getItemViewType(int position)
  - public boolean hasStableIds()
  - public View getView(int position, View convertView, ViewGroup parent)
  - private AbsQuizView getViewInternal(Quiz quiz)
  - private AbsQuizView createViewFor(Quiz quiz)
## ScoreAdapter - 目前玩家總分
### method
  - public ScoreAdapter(Category category)
  - public int getCount()
  - public Quiz getItem(int position)
  - public long getItemId(int position)
  - public View getView(int position, View convertView, ViewGroup parent)
  - private void setSolvedStateForQuiz(ImageView solvedState, int position)
  - private Drawable getSuccessIcon(Context context)
  - private Drawable getFailedIcon(Context context)
  - private Drawable loadAndTint(Context context, @DrawableRes int drawableId,@ColorRes int tintColor)
  - private View createView(ViewGroup parent)
# fragement - 設計UI在切換方向時控制項配置
## SignInFragment - 登入畫面配置
### method
  - public static SignInFragment newInstance(boolean edit)
  - public void onCreate(Bundle savedInstanceState)
  - public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState)
  - public void onSaveInstanceState(Bundle outState)
  - public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
  - private void checkIsInEditMode()
  - private void initContentViews(View view)
  -  private void removeDoneFab(@Nullable Runnable endAction)
  -  private void setUpGridView(View container)
  -  private void performSignInWithTransition(View v)
  -  private void initContents()
  -  private void assurePlayerInit()
  -  private void savePlayer(Activity activity)
  -  private int calculateSpanCount()
## CategorySelectionFragment - 題庫
### method
  - public static CategorySelectionFragment newInstance()
  - public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
  - public void onViewCreated(View view, Bundle savedInstanceState)
  - private void setUpQuizGrid(GridView categoriesView)
  - public void onResume()
  - private void startQuizActivityWithTransition(Activity activity, View toolbar, Category category)
## QuizFragment - 測驗遊戲
### method
  - public static QuizFragment newInstance(String categoryId,SolvedStateListener solvedStateListener)
  - public void onCreate(Bundle savedInstanceState)
  - public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState)
  - public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
  - private void initProgressToolbar(View view)
  - private void setProgress(int currentQuizPosition)
  - private void setAvatarDrawable(AvatarView avatarView)
  - private void decideOnViewToDisplay()
  - public void onSaveInstanceState(Bundle outState)
  - public void onViewStateRestored(Bundle savedInstanceState)
  - private void restoreQuizState(final Bundle savedInstanceState)
  - private QuizAdapter getQuizAdapter()
  - public boolean showNextPage()
  - private void markCategorySolved() 
  - public void showSummary()
  - private ScoreAdapter getScoreAdapter()
  - public interface SolvedStateListener 
# helper - 幫助取得程式所需的內容
## AnswerHelper - 取得使用者的答案
### method
  - public static String getAnswer(String[] answers)
  - public static String getAnswer(int[] answers, String[] options)
  - public static boolean isAnswerCorrect(SparseBooleanArray checkedItems, int[] answerIds)
## JsonHelper - 取得題目
### method
  - public static String[] jsonArrayToStringArray(String json)
  - public static int[] jsonArrayToIntArray(String json)
## ParcelableHelper - 取得其他Activity的資料，使用Parcel傳遞
### method
  - public static void writeBoolean(Parcel dest, boolean toWrite)
  - public static boolean readBoolean(Parcel in)
  - public static void writeEnumValue(Parcel dest, Enum e)
## PreferencesHelper - 取得永續暫存資料，下次開啟時能夠繼承上回遊玩紀錄
### method
  - public static void writeToPreferences(Context context, Player player)
  - public static Player getPlayer(Context context)
  - public static void signOut(Context context)
  - public static boolean isSignedIn(Context context)
  - private static SharedPreferences.Editor getEditor(Context context)
  - private static SharedPreferences getSharedPreferences(Context context)
## TransitionHelper - 取得轉場動畫設定
### method
  - public static Pair[] createSafeTransitionParticipants(@NonNull Activity activity,boolean includeStatusBar, @Nullable Pair... otherParticipants)
  - private static void addNonNullViewToTransitionParticipants(View view, List<Pair> participants)
# model - 建立各測驗類型的模組與自定義類別
## AlphaPickerQuiz - 英文單字填寫
### method
  - public AlphaPickerQuiz(String question, String answer, boolean solved)
  - public AlphaPickerQuiz(Parcel in)
  - public QuizType getType()
  - public String getStringAnswer()
  - public void writeToParcel(Parcel dest, int flags)
## FillBlanckQuiz - 填空題
  - public FillBlankQuiz(String question, String answer, String start, String end, boolean solved)
  - public FillBlankQuiz(Parcel in)
  - public String getStringAnswer()
  - public String getStart()
  - public String getEnd()
  - public QuizType getType()
  - public void writeToParcel(Parcel dest, int flags)
## FillTwoBlanksQuiz - 雙填空題
  - public FillTwoBlanksQuiz(String question, String[] answer, boolean solved)
  - public FillTwoBlanksQuiz(Parcel in)
  - public QuizType getType()
  - public String getStringAnswer()
  - public void writeToParcel(Parcel dest, int flags)
  - public boolean equals(Object o)
  - public int hashCode()
## FourQuarterQuiz - 四選一
### method
  - public FourQuarterQuiz createFromParcel(Parcel in)
  - public FourQuarterQuiz[] newArray(int size)
  - public FourQuarterQuiz(String question, int[] answer, String[] options, boolean solved)
  - public FourQuarterQuiz(Parcel in)
  - public QuizType getType()
  - public String getStringAnswer()
  - public int describeContents()
  - public void writeToParcel(Parcel dest, int flags) 
  - public boolean equals(Object o)
  - public int hashCode()
## MultiSelectQuiz - 多選題
### method 
  - public MultiSelectQuiz(String question, int[] answer, String[] options, boolean solved)
  - public MultiSelectQuiz(Parcel in)
  - public QuizType getType()
  - public String getStringAnswer()
  - public void writeToParcel(Parcel dest, int flags)
## OptionQuiz - 選項事件建置，設定答案選項、比對回傳，繼承至Quiz，再繼承給各類Quiz
### method
  - public OptionsQuiz(String question, int[] answer, T[] options, boolean solved)
  - public OptionsQuiz(Parcel in)
  - public T[] getOptions()
  - protected void setOptions(T[] options)
  - public boolean isAnswerCorrect(int[] answer)
  - public int describeContents()
  - public void writeToParcel(Parcel dest, int flags)
  - public boolean equals(Object o) 
  - public int hashCode()
## PickerQuiz - 數字條
### method
  - public PickerQuiz(String question, Integer answer, int min, int max, int step, boolean solved)
  - public PickerQuiz(Parcel in)
  - public int getMin()
  - public int getMax()
  - public int getStep()
  - public QuizType getType()
  - public String getStringAnswer()
  - public void writeToParcel(Parcel dest, int flags)
  - public boolean equals(Object o)
  - public int hashCode()
## Quiz - 所有問題類型的源頭，引進Parcelable介面，實現Parcel技術，繼承給OptionsQuiz
### method
  - public Quiz createFromParcel(Parcel in)
  - public Quiz[] newArray(int size)
  - protected Quiz(String question, A answer, boolean solved)
  - protected Quiz(Parcel in)
  - public String getQuestion()
  - public A getAnswer()
  - protected void setAnswer(A answer)
  - public boolean isAnswerCorrect(A answer)
  - public boolean isSolved()
  - public void setSolved(boolean solved)
  - public int getId()
  - public int describeContents()
  - public void writeToParcel(Parcel dest, int flags)
  - public boolean equals(Object o)
  - public int hashCode()
  - public String toString()
## QuizType - Enum，列舉出所有題目類型，分析json檔内type，讓Quiz知道要交給哪個問題類型去運作
### method
  - public String getJsonName()
  - public Class<? extends Quiz> getType()
## SelectItemQuiz - 單選題，選項可能有4個以上
### method
  - public SelectItemQuiz(String question, int[] answer, String[] options, boolean solved)
  - public SelectItemQuiz(Parcel in) 
  - public QuizType getType()
  - public String getStringAnswer()
  - public void writeToParcel(Parcel dest, int flags)
## ToggleTranslateQuiz - 對應(轉換)題
### method
  - public ToggleTranslateQuiz(String question, int[] answer, String[][] options, boolean solved)
  - public ToggleTranslateQuiz(Parcel in)
  - public QuizType getType()
  - public String getStringAnswer()
  - public String[] getReadableOptions()
  - private String createReadablePair(String[] option)
  - public void writeToParcel(Parcel dest, int flags)
  - public boolean equals(Object o)
  - public int hashCode()
## TrueFalseQuiz - 真假題
### method
  - public TrueFalseQuiz(String question, Boolean answer, boolean solved)
  - public TrueFalseQuiz(Parcel in)
  - public String getStringAnswer()
  - public QuizType getType()
  - public void writeToParcel(Parcel dest, int flags)
## Avatar - Enum，列舉頭像對應的圖檔
### method
  - public int getDrawableId()
  - public String getNameForAccessibility()
## Category - 自定義類別，題庫
### method
  - public Category(@NonNull String name, @NonNull String id, @NonNull Theme theme,@NonNull List<Quiz> quizzes, boolean solved)
  - public Category(String name, String id, Theme theme, List<Quiz> quizzes, int[] scores,boolean solved)
  - protected Category(Parcel in)
  - public String getName()
  - public String getId()
  - public Theme getTheme()
  - public List<Quiz> getQuizzes()
  - public void setScore(Quiz which, boolean correctlySolved)
  - public boolean isSolvedCorrectly(Quiz quiz)
  - public int getScore(Quiz which)
  - public int getScore()
  - public int[] getScores()
  - public boolean isSolved()
  - public void setSolved(boolean solved)
  - public int getFirstUnsolvedQuizPosition()
  - public String toString()
  - public int describeContents()
  - public void writeToParcel(Parcel dest, int flags)
  - public boolean equals(Object o)
  - public int hashCode()
## Player - 自定義類別，玩家
### method
  - public Player(String firstName, String lastInitial, Avatar avatar)
  - protected Player(Parcel in)
  - public String getFirstName()
  - public String getLastInitial()
  - public Avatar getAvatar()
  - public int describeContents()
  - public void writeToParcel(Parcel dest, int flags)
  - public boolean equals(Object o)
  - public int hashCode()
## Theme - Enum，列舉出主題色，以填入題庫的主體顏色
### method
  - public int getTextPrimaryColor()
  - public int getWindowBackgroundColor()
  - public int getPrimaryColor()
  - public int getStyleId()
# president
## TopekaDatabaseHelper - 小型資料庫的建立，以儲存各題庫的答題狀況與回答情形
### method
  - private TopekaDatabaseHelper(Context context) 
  - private static TopekaDatabaseHelper getInstance(Context context)
  - public static List<Category> getCategories(Context context, boolean fromDatabase)
  - private static List<Category> loadCategories(Context context)
  - private static Cursor getCategoryCursor(Context context)
  - private static Category getCategory(Cursor cursor, SQLiteDatabase readableDatabase)
  - private static boolean getBooleanFromDatabase(String isSolved)
  - public static Category getCategoryWith(Context context, String categoryId)
  - public static int getScore(Context context)
  - public static void updateCategory(Context context, Category category)
  - private static void updateQuizzes(SQLiteDatabase writableDatabase, List<Quiz> quizzes)
  - public static void reset(Context context)
  - private static List<Quiz> getQuizzes(final String categoryId, SQLiteDatabase database)
  - private static Quiz createQuizDueToType(Cursor cursor)
  - private static Quiz createFillBlankQuiz(Cursor cursor, String question, String answer,boolean solved)
  - private static Quiz createFillTwoBlanksQuiz(String question, String answer, boolean solved)
  - private static Quiz createFourQuarterQuiz(String question, String answer, String options,boolean solved)
  - private static Quiz createMultiSelectQuiz(String question, String answer, String options,boolean solved)
  - private static Quiz createSelectItemQuiz(String question, String answer, String options,boolean solved)
  - private static QuizcreateToggleTranslateQuiz(String question, String answer, String options,boolean solved)
  - private static Quiz createTrueFalseQuiz(String question, String answer, boolean solved)
  - private static String[][]extractOptionsArrays(String options)
  - private static ContentValues createContentValuesFor(Category category)
  - private static SQLiteDatabase getReadableDatabase(Context context)
  - private static SQLiteDatabase getWritableDatabase(Context context)
  - public void onCreate(SQLiteDatabase db)
  - public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
  - private void preFillDatabase(SQLiteDatabase db)
  - private void fillCategoriesAndQuizzes(SQLiteDatabase db) throws JSONException, IOException
  - private String readCategoriesFromResources() throws IOException
  - private void fillCategory(SQLiteDatabase db, ContentValues values, JSONObject category,String categoryId) throws JSONException)
  - private void fillQuizzesForCategory(SQLiteDatabase db, ContentValues values, JSONArray quizzes,String categoryId) throws JSONException)
  - private void putNonEmptyString(ContentValues values, JSONObject quiz, String jsonKey,String contentKey) throws JSONException)
# widget - 跟使用者互動的小工具
## CheckableFab - 檢查答案正確後，設定按紐要為勾或叉
### method
  - public CheckableFab(Context context)
  - public CheckableFab(Context context, AttributeSet attrs)
  - public CheckableFab(Context context, AttributeSet attrs, int defStyle)
  - public int[] onCreateDrawableState(int extraSpace)
  - public void setChecked(boolean checked)
  - public boolean isChecked()
  - public void toggle()
## DoneFab - 完成按鈕，繼承至FloatingActionButton
### method
  - public DoneFab(Context context)
  - public DoneFab(Context context, AttributeSet attrs)
  - public DoneFab(Context context, AttributeSet attrs, int defStyle)
## FloatingActionButton - 設定浮動按鈕的外觀
### method 
  - public FloatingActionButton(Context context)
  - public FloatingActionButton(Context context, AttributeSet attrs)
  - public FloatingActionButton(Context context, AttributeSet attrs, int defStyle)
  - protected void onSizeChanged(int w, int h, int oldw, int oldh)
## RoundOutlineProvider
### method
  - public RoundOutlineProvider(int size)
  - public final void getOutline(View view, Outline outline)
## AbsQuizView - 所有問題的介面設定繼承自此程式碼
### method
  - public AbsQuizView(Context context, Category category, Q quiz)
  - private void setUpQuestionView()
  - private LinearLayout createContainerLayout(Context context)
  - private View getInitializedContentView()
  - private void addContentView(LinearLayout container, View quizContentView)
  - private void addFloatingActionButton()
  - private CheckableFab getSubmitButton(Context context)
  - private void setDefaultPadding(View view)
  - protected LayoutInflater getLayoutInflater()
  - protected abstract View createQuizContentView()
  - protected abstract boolean isAnswerCorrect()
  - public abstract Bundle getUserInput()
  - public abstract void setUserInput(Bundle savedInput)
  - public Q getQuiz()
  - protected boolean isAnswered()
  - protected void allowAnswer(final boolean answered)
  - protected void allowAnswer()
  - protected void submitAnswer()
  - private void submitAnswer(final View v)
  -  private void performScoreAnimation(final boolean answerCorrect)
  -  private void resizeView()
  -  private void animateFabBackgroundColor(int backgroundColor)
  -  private void animateForegroundColor(int targetColor)
  -  private void moveViewOffScreen(final boolean answerCorrect)
  -  private void setMinHeightInternal(View view, @DimenRes int resId)
## AlphaPickerQuizView - 字母挑選題外觀
### method
  - public AlphaPickerQuizView(Context context, Category category, AlphaPickerQuiz quiz)
  - protected View createQuizContentView()
  - protected boolean isAnswerCorrect()
  - public Bundle getUserInput()
  - public void setUserInput(Bundle savedInput)
  - private List<String> getAlphabet()
## FillBlankQuizView - 填空題外觀
### method
  - public FillBlankQuizView(Context context, Category category, FillBlankQuiz quiz)
  - protected View createQuizContentView() 
  - public Bundle getUserInput()
  - public void setUserInput(Bundle savedInput)
  - private View getStartEndView(String start, String end)
  - private void setExistingContentOrHide(TextView view, String content)
  - protected boolean isAnswerCorrect()
## FillTwoBlankQuizView - 雙填題外觀
### method
  - public FillTwoBlanksQuizView(Context context, Category category, FillTwoBlanksQuiz quiz)
  - protected View createQuizContentView()
  - public Bundle getUserInput()
  - public void setUserInput(Bundle savedInput)
  - private void addEditText(LinearLayout layout, EditText editText)
  - protected boolean isAnswerCorrect()
  - private String getAnswerFrom(EditText view)
  - public void setUserInput(Bundle savedInput)
  - private void addEditText(LinearLayout layout, EditText editText)
  - protected boolean isAnswerCorrect()
  - private String getAnswerFrom(EditText view)
## FourQuarterQuizTest - 四選一題目外觀
### method
  - public FourQuarterQuizView(Context context, Category category, FourQuarterQuiz quiz)
  - protected View createQuizContentView()
  - public Bundle getUserInput()
  - public void setUserInput(Bundle savedInput)
  - private void setUpUserInput()
  - protected boolean isAnswerCorrect()
## MultiSelectQuizView - 多選題外觀
### method
  - public MultiSelectQuizView(Context context, Category category, MultiSelectQuiz quiz)
  - protected View createQuizContentView()
  - protected boolean isAnswerCorrect()
  - public Bundle getUserInput()
  - public void setUserInput(Bundle savedInput)
  - private boolean[] getBundleableAnswer()
## PickerQuizView - 選數題外觀
### method
  - public PickerQuizView(Context context, Category category, PickerQuiz quiz) 
  - protected View createQuizContentView()
  - private void setCurrentSelectionText(int progress)
  - protected boolean isAnswerCorrect()
  - private void initStep()
  - public Bundle getUserInput()
  - public void setUserInput(Bundle savedInput)
  - private int getSeekBarMax()
## SelectItemQuizView - 單選題外觀
### method
  - public SelectItemQuizView(Context context, Category category, SelectItemQuiz quiz)
  - protected View createQuizContentView()
  - protected boolean isAnswerCorrect()
  - public Bundle getUserInput()
  - public void setUserInput(Bundle savedInput)
  - private void toggleAnswerFor(int answerId)
  - private boolean[] getAnswers()
## TextInputQuizView - 填空與雙填題的父程式
### method
  - public TextInputQuizView(Context context, Category category, Q quiz)
  - protected final EditText createEditText()
  - protected void submitAnswer()
  - protected void hideKeyboard(View view)
  - private InputMethodManager getInputMethodManager()
  - public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
  - public void beforeTextChanged(CharSequence s, int start, int count, int after)
  - public void onTextChanged(CharSequence s, int start, int before, int count)
  - public void afterTextChanged(Editable s)
## ToggleTranslateQuizView - 對應題外觀
### method
  - public ToggleTranslateQuizView(Context context, Category category, ToggleTranslateQuiz quiz)
  - protected View createQuizContentView()
  - protected boolean isAnswerCorrect()
  - public Bundle getUserInput() 
  - public void setUserInput(Bundle savedInput)
  - private void toggleAnswerFor(int answerId)
## TrueFalseQuizView - 真假題
### method
  - public TrueFalseQuizView(Context context, Category category, TrueFalseQuiz quiz)
  - protected View createQuizContentView()
  - protected boolean isAnswerCorrect()
  - public Bundle getUserInput()
  - public void setUserInput(Bundle savedInput) 
  - private void performSelection(View selection)
## AvatarView - 頭像外觀
### method 
  - public AvatarView(Context context)
  - public AvatarView(Context context, AttributeSet attrs)
  - public AvatarView(Context context, AttributeSet attrs, int defStyle)
  - public void setChecked(boolean b)
  - public boolean isChecked()
  - public void toggle() 
  - protected void onDraw
  - protected void onSizeChanged(int w, int h, int oldw, int oldh)

## Change Points
### categorires.json
 - 將全部題目改成中文
 - 變更各題庫的主題色
 - 新增Gossiping，icon自訂，刪除Entertainment
### AbsQuizView.java
 - performScoreAnimation裡新增完成題目時，floattingButton更加生動的動畫
 - 在submitAnswer的方法裡加入hideKeyboard，完成填空題時就能夠自動隱藏鍵盤
### theme.java
 - 配置active、techie、leisured、sweet、futuristic、cyan、fresh、honest、passion九個主題色
### color.xml
 - 新增active、techie、leisured、sweet、futuristic、cyan、fresh、honest、passion共九個主題的色碼
### string.xml
 - string appname改成「您地質系?」
 - 將string btn_true與btn_false改為對與錯
### avatar.java
 - 將enum的人物頭像，改為自訂的新頭像
